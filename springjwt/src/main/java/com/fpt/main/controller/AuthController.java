package com.fpt.main.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import net.bytebuddy.utility.RandomString;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fpt.main.advice.SendEmailService;
import com.fpt.main.advice.HandleMultipartFile;
import com.fpt.main.exception.TokenRefreshException;
import com.fpt.main.model.ERole;
import com.fpt.main.model.RefreshToken;
import com.fpt.main.model.Role;
import com.fpt.main.model.User;
import com.fpt.main.payload.request.LoginRequest;
import com.fpt.main.payload.request.SignupRequest;
import com.fpt.main.payload.request.TokenRefreshRequest;
import com.fpt.main.payload.response.JwtResponse;
import com.fpt.main.payload.response.MessageResponse;
import com.fpt.main.payload.response.TokenRefreshResponse;
import com.fpt.main.reponsitory.RoleReponsitory;
import com.fpt.main.reponsitory.UserRepository;
import com.fpt.main.security.jwt.JwtUtils;
import com.fpt.main.services.RefreshTokenService;
import com.fpt.main.services.UserDetailsImpl;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userReponsitory;

	@Autowired
	RoleReponsitory roleReponsitory;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@Autowired
	SendEmailService sendEmailService;

	@Autowired
	RefreshTokenService refreshTokenService;
	
	@Autowired
	HandleMultipartFile handleMultipartFile;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		String error = "";
		try {
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
			
			SecurityContextHolder.getContext().setAuthentication(authentication);
			String jwt = jwtUtils.generateJwtToken(authentication);

			UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
			List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
					.collect(Collectors.toList());

			RefreshToken refreshToken = refreshTokenService.createRefreshToken(userDetails.getId());
			return ResponseEntity
					.ok(new JwtResponse(jwt, refreshToken.getToken(), userDetails.getId(), userDetails.getUsername(),
							userDetails.getEmail(), userDetails.getAddress(), userDetails.getPhonenumber(), roles));
		} catch (BadCredentialsException ex) {
			ex.printStackTrace();
			error += ex.getMessage();
		} catch (LockedException ex) {
			ex.printStackTrace();
			error += ex.getMessage();
		} catch (DisabledException ex) {
			ex.printStackTrace();
			error += ex.getMessage();
		} catch (Exception ex) {
			ex.printStackTrace();
			error += ex.getMessage();
		}
		return ResponseEntity.badRequest().body(error);
	}

	@PostMapping("/signup")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody SignupRequest signupRequest) throws RuntimeException, MalformedURLException {
		if (userReponsitory.existsByUserName(signupRequest.getUsername())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userReponsitory.existsByEmail(signupRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account
		User user = new User(signupRequest.getUsername(), signupRequest.getEmail(),
				encoder.encode(signupRequest.getPassword()));
		// Create active Code
		user.setVerifycationCode(RandomString.make(64));
		//Set Role
		Set<String> strRoles = signupRequest.getRole();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleReponsitory.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleReponsitory.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);
					break;
				case "mod":
					Role modRole = roleReponsitory.findByName(ERole.ROLE_MODERATOR)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(modRole);

					break;
				default:
					Role userRole = roleReponsitory.findByName(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}
		user.setRoles(roles);			
		userReponsitory.save(user);	
		sendEmailService.sendEmail(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully! Email just send with active code!"));
	}

	@PostMapping("/refreshtoken")
	public ResponseEntity<?> refreshtoken(@Valid @RequestBody TokenRefreshRequest request) {
		String requestRefreshToken = request.getRefreshToken();

		return refreshTokenService.findByToken(requestRefreshToken).map(refreshTokenService::verifyExpiration)
				.map(RefreshToken::getUser).map(user -> {
					String token = jwtUtils.generateTokenFromUsername(user.getUsername());
					return ResponseEntity.ok(new TokenRefreshResponse(token, requestRefreshToken));
				})
				.orElseThrow(() -> new TokenRefreshException(requestRefreshToken, "Refresh token is not in database!"));
	}
	
	@GetMapping("/profile/{username}")
	@ResponseBody
	public ResponseEntity<?> getProfileByUsername(@PathVariable String username) {
		User user = userReponsitory.findByUserName(username).orElseThrow(() -> new RuntimeException("User not found!"));
		return ResponseEntity.ok(user);
	}
	
	@PostMapping("/profile")
	public ResponseEntity<?> updateProfile(@Valid @RequestBody User user,
										   		  @RequestParam(name="fileImage",required = false) MultipartFile multipartFile) throws IOException{
		
		
		//handle MultipartFile
		if (multipartFile.getSize()> 0) {
			String fileName = handleMultipartFile.SaveAvatarImage(multipartFile, user.getId());
			user.setAvatar(fileName);
		}
		
		User currentUser = userReponsitory.findByUserName(user.getUsername()).orElseThrow(() -> new RuntimeException("User not found! Update Profile Failure!" ));
		if (!user.getId().equals(currentUser.getId())) {return ResponseEntity.badRequest().body(new MessageResponse("Update Profile Failure!"));}
		userReponsitory.save(user);
		return ResponseEntity.ok(new MessageResponse("Update Profile Successful!"));		
	}	
	
	@GetMapping("/active/{username}/{verifyCode}")
	@ResponseBody
	public ResponseEntity<?> activedUserByEmail(@PathVariable String verifyCode, 
												@PathVariable String username) throws URISyntaxException {
		
		User currentUser = userReponsitory.findByUserName(username).orElseThrow(() -> new RuntimeException("User not found! Update Profile Failure!" ));
		if (currentUser != null) {
			if (currentUser.getVerifycationCode().equals(verifyCode)) {
				currentUser.setActive(true);
				userReponsitory.save(currentUser);
				URI loginPage = new URI("http://localhost:4200/login");
			    HttpHeaders httpHeaders = new HttpHeaders();
			    httpHeaders.setLocation(loginPage);
			    return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
			}
		}
		return ResponseEntity.badRequest().body(new MessageResponse("Can not Active User!"));
	}
	
}