package com.fpt.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpt.main.dto.FavouritesDto;
import com.fpt.main.entity.Customer;
import com.fpt.main.entity.Favourites;
import com.fpt.main.entity.Restaurant;
import com.fpt.main.reponsitory.CustomerRespository;
import com.fpt.main.reponsitory.FavouritesResponsitory;
import com.fpt.main.reponsitory.RestaurantRepository;

import javassist.NotFoundException;

@Service
public class FavouritesServiceImpl implements FavouritesService{
	
	@Autowired
	private CustomerRespository customerRespository;
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Autowired
	private FavouritesResponsitory favouritesResponsitory;

	@Override
	public boolean addFavourites(FavouritesDto dto) throws NotFoundException {
		
		String theEmail = dto.getCustomerEmail().toString().replace("\"", "");
		
		System.out.println(theEmail);
		
		if (theEmail.isEmpty()) {
			throw new NotFoundException("Cannot find User");
		}
		
		Customer customer = customerRespository.findByEmail(theEmail);		
		if (customer == null) {
			customer = new Customer();
			customer.setEmail(theEmail);			
			customer.setFullName(theEmail.split("@")[0]);
			customerRespository.save(customer);
		}
		
		Restaurant restaurant = restaurantRepository.findById(dto.getRestaurantId())
													.orElseThrow(() -> new RuntimeException("Restaurant not found !"));
		
		Favourites model = new Favourites();	
		model.setCustomer(customer);	
		model.setRestaurant(restaurant);
		favouritesResponsitory.save(model);
		
		return true;
	}

	@Override
	public boolean removeFavourites(Long id) {
		favouritesResponsitory.deleteById(id);
		return true;
	}

}
