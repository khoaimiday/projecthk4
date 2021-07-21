package com.fpt.main.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fpt.main.entity.DishCategories;

public interface DishCategoriesRepository extends JpaRepository<DishCategories, Long> {
}
