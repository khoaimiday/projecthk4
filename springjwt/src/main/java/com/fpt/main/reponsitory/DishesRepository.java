package com.fpt.main.reponsitory;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.fpt.main.entity.Dishes;

@RepositoryRestResource
public interface DishesRepository extends JpaRepository<Dishes, Long> {
	
	//@Query("SELECT u FROM Dishes u WHERE u.restaurant.id = :res")
	//http://localhost:8080/api/disheses/search/findAllByRestaurantId?id=?
	public Page<Dishes> findAllByRestaurantId(@Param("id")Long id, Pageable pageable);
	
	//@Query("SELECT * FROM Dishes u WHERE u.fullName = :name")
	//http://localhost:8080/api/disheses/search/findByNameContaining?name=?
	public Page<Dishes> findByNameContaining(@Param("name") String name, Pageable pageable); 
	
	//http://localhost:8080/api/disheses/search/findAllByDishCategoryId?id=?
	public Page<Dishes> findAllByDishCategoryId(@Param("id")Long id, Pageable pageable); 
	
}
