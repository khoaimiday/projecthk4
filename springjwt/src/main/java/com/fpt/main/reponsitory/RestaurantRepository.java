package com.fpt.main.reponsitory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.fpt.main.entity.Restaurant;

@RepositoryRestResource
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

	//@Query("SELECT * FROM Dishes u WHERE u.fullName = :name")
	//http://localhost:8080/api/restaurants/search/findByFullNameContaining?name=?
	public Page<Restaurant> findByFullNameContaining(@Param("name") String name, Pageable pageable);
}
