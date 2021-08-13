package com.fpt.main.services;

import java.util.List;

import com.fpt.main.dto.FavouritesDto;
import com.fpt.main.entity.Restaurant;

import javassist.NotFoundException;

public interface FavouritesService {

	boolean addFavourites(FavouritesDto dto) throws NotFoundException;

	boolean removeFavourites(FavouritesDto dto);
	
	List<Restaurant> getFavourites(String email);
}
