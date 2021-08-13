package com.fpt.main.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpt.main.dto.FavouritesDto;
import com.fpt.main.entity.Customer;
import com.fpt.main.entity.Restaurant;
import com.fpt.main.reponsitory.CustomerRespository;
import com.fpt.main.reponsitory.RestaurantRepository;

import javassist.NotFoundException;

@Service
public class FavouritesServiceImpl implements FavouritesService {

	@Autowired
	CustomerRespository customerRespository;

	@Autowired
	RestaurantRepository restaurantRepository;

	@Override
	public boolean addFavourites(FavouritesDto dto) throws NotFoundException {
		
		Customer customer = customerRespository.findByEmail(dto.getCustomerEmail().replace("\"", ""));

		if (customer == null) {
			customer = new Customer();
			customer.setEmail(dto.getCustomerEmail());
			customer.setFullName(dto.getCustomerEmail().split("@")[0]);
		}

		Restaurant restaurant = null;
		
		Optional<Restaurant> result = restaurantRepository.findById(dto.getRestaurantId());
		if (result.isPresent()) {
			restaurant = result.get();
		}else {
			return false;
		}

		customer.addRestaurantFavou(restaurant);
		customerRespository.save(customer);
		
		return true;
	}

	@Override
	public boolean removeFavourites(FavouritesDto dto) {
		Customer customer = customerRespository.findByEmail(dto.getCustomerEmail());

		if (customer == null) {
			return false;
		}
		
		Restaurant restaurant = null;		
		Optional<Restaurant> result = restaurantRepository.findById(dto.getRestaurantId());
		if (result.isPresent()) {
			restaurant = result.get();
		}else {
			return false;
		}
		
		customer.getRestaurantFavou().remove(restaurant);
		customerRespository.save(customer);
		
		return true;
	}
	
	public List<Restaurant> getFavourites(String email){
		
		List<Restaurant> list = new ArrayList<Restaurant>();
		
		Customer customer = customerRespository.findByEmail(email);
		
		if(customer == null) {
			return list;
		}
		
		list.addAll(customer.getRestaurantFavou());		
		return list;
		
	}

}
