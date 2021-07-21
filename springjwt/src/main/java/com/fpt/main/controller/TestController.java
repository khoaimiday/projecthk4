package com.fpt.main.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fpt.main.advice.HandleMultipartFile;
import com.fpt.main.entity.Dishes;
import com.fpt.main.reponsitory.DishesRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	
	@Autowired
	DishesRepository dishesRepository;

	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public String userAccess() {
		return "User Content.";
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
