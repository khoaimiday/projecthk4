package com.fpt.main.reponsitory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;

import com.fpt.main.entity.Address;

@RepositoryRestResource
public interface AddressRepository extends JpaRepository<Address, Long> {


	//http:localhost:8080/api/addresses/search/findByRestaurant?id=?
	@Query("SELECT address FROM Address address WHERE address.restaurant.id = :id ")
	public Address findByRestaurant(@RequestParam("id") Long id);
	
	
	//http://localhost:8080/api/addresses/search/findAllByUsers?id=?
//	@Query("SELECT address FROM Address address WHERE address.user.id = :id")
//	public Page<Address> findAllByUser(@RequestParam("id") Long id, Pageable pageable);
	
	public Page<Address> findAllByCustomer(@RequestParam("id") Long id, Pageable pageable);
	
}
