package com.fpt.main.reponsitory;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import com.fpt.main.entity.Dishes;

@CrossOrigin("http://localhost:4200")
public interface DishesRepository extends JpaRepository<Dishes, Long> {
	
	//@Query("SELECT u FROM Dishes u WHERE u.restaurant.id = :res")
	//http://localhost:8080/api/disheses/search/findAllByRestaurantId?id=?
	public Page<Dishes> findAllByRestaurantId(@RequestParam("id")Long id, Pageable pageable);
	
	//@Query("SELECT * FROM Dishes u WHERE u.fullName = :name")
	//http://localhost:8080/api/disheses/search/findByFullNameContaining?name=?
	public Page<Dishes> findByFullNameContaining(@RequestParam("name") String name, Pageable pageable); 
	
	//http://localhost:8080/api/disheses/search/findAllByDishCategoryId?id=?
	public Page<Dishes> findAllByDishCategoryId(@RequestParam("id")Long id, Pageable pageable); 
}
