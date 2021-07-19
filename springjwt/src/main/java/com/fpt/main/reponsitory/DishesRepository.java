package com.fpt.main.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fpt.main.model.Dishes;

public interface DishesRepository extends JpaRepository<Dishes, Long> {
}
