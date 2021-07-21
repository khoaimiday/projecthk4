package com.fpt.main.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fpt.main.entity.Rating;

public interface RatingRepository extends JpaRepository<Rating, Long> {

}
