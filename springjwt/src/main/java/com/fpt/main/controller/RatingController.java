package com.fpt.main.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fpt.main.dto.RatingDto;
import com.fpt.main.entity.Restaurant;
import com.fpt.main.services.RatingService;

import javassist.NotFoundException;

@Controller
@RequestMapping("/api/rating")
public class RatingController {

	private RatingService ratingService;
	
	private RatingController(RatingService ratingService) {
		this.ratingService = ratingService;
	}
	
	@PostMapping("/restaurant")
	public ResponseEntity<Restaurant> ratingForRestaurant(@RequestBody RatingDto ratingDto) throws NotFoundException {
		
		Restaurant restaurant = ratingService.ratingForRestaurant(ratingDto);
		
		return new ResponseEntity<>(restaurant, HttpStatus.OK);
	}
	
}
