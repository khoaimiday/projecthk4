package com.fpt.main.services;

import com.fpt.main.dto.FavouritesDto;

import javassist.NotFoundException;

public interface FavouritesService {

	boolean addFavourites(FavouritesDto dto) throws NotFoundException;

	boolean removeFavourites(Long id);
}
