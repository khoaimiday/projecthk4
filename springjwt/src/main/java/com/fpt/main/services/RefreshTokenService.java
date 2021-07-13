package com.fpt.main.services;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fpt.main.reponsitory.RefreshTokenReponsitory;
import com.fpt.main.reponsitory.UserRepository;
import com.fpt.main.exception.TokenRefreshException;
import com.fpt.main.model.RefreshToken;


@Service
public class RefreshTokenService {
	
	@Value("${com.fpt.jwtRefreshExpirationMs}")
	private Long refreshTokenDurations;
	
	@Autowired
	private RefreshTokenReponsitory refreshTokenReponsitory;
	
	@Autowired
	private UserRepository userRepository;

	public Optional<RefreshToken>  findByToken(String token){
		return refreshTokenReponsitory.findByToken(token);
	}
	
	public RefreshToken createRefreshToken(Long userId) {
		RefreshToken refreshToken = new RefreshToken();
		refreshToken.setUser(userRepository.findById(userId).get());
		
		refreshToken.setExpiryDate(Instant.now().plusMillis(refreshTokenDurations));
		refreshToken.setToken(UUID.randomUUID().toString());
		
		refreshToken = refreshTokenReponsitory.save(refreshToken);
		return refreshToken;
		
	}
	
	public RefreshToken verifyExpiration(RefreshToken token) {
		if (token.getExpiryDate().compareTo(Instant.now())< 0) {
			refreshTokenReponsitory.delete(token);
			throw new TokenRefreshException(token.getToken(), "Refresh token was exprired.Please make a new signin request");
		}
		return token;
	}
	
	@Transactional
	public int deleteUserId(Long userId) {
		return refreshTokenReponsitory.deleteByUser(userRepository.findById(userId).get());
	}
	
}
