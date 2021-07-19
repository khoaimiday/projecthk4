package com.fpt.main.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fpt.main.model.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
