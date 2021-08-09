package com.fpt.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fpt.main.dto.FavouritesDto;
import com.fpt.main.services.FavouritesService;

import javassist.NotFoundException;

@Controller
@RequestMapping("/api/favourites")
public class FavouritesController {
	
	@Autowired
	FavouritesService favouritesService;
	
	@PostMapping
	public ResponseEntity<Boolean> addWish(@RequestBody FavouritesDto dto) throws NotFoundException {
				
		boolean result = favouritesService.addFavourites(dto);		
		
		return new ResponseEntity<>(result ,HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<Boolean> deleteWish(@PathVariable Long id) throws NotFoundException {
				
		boolean result = favouritesService.removeFavourites(id);		
		
		return new ResponseEntity<>(result ,HttpStatus.OK);
	}

}
