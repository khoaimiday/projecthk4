package com.fpt.main.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.activation.DataSource;
import javax.activation.FileDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fpt.main.advice.HandleMultipartFile;
import com.fpt.main.dto.FavouritesDto;
import com.fpt.main.reponsitory.DishesRepository;
import com.fpt.main.services.ReportService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	
	@Autowired
	DishesRepository dishesRepository;
	
	@Autowired
	private ReportService reportService;
	
	@GetMapping(value = "pdf-report", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<byte[]> getPDFReport() {
		try {
//			return new ResponseEntity<byte[]>(reportService.generatePDFReport(), HttpStatus.OK);
			return new ResponseEntity<byte[]>(HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	 private static void writeBytesToFile(String fileOutput, byte[] bytes)
		        throws IOException {

		        try (FileOutputStream fos = new FileOutputStream(fileOutput)) {
		            fos.write(bytes);
		        }

	 }

	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public String userAccess() {
		return "User Content.";
	}
	
	@PostMapping("/user")
	public String userAccess1() {
		return "User Content.";
	}
		
	@PostMapping("/favourite")
	public String testFavourite(@RequestBody FavouritesDto dto) {
//		 request.getRequestDispatcher("/api/favourites").forward(request, response);
		return "success";
	}
	
	@GetMapping("/mod")
	@PreAuthorize("hasRole('MODERATOR')")
	public String moderatorAccess() {
		return "Moderator Board.";
	}
	
	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}
	
	@PostMapping("/profile")
	public String testUploadImage(@RequestParam(name="fileImage",required = false) MultipartFile multipartFile) throws IOException {
		HandleMultipartFile handleMultipartFile = new HandleMultipartFile();
		if (multipartFile != null && !multipartFile.isEmpty()) {
			String fileName = handleMultipartFile.SaveAvatarImage(multipartFile, 123L);
			return fileName;
		}	
		return null;
	}
	

}
