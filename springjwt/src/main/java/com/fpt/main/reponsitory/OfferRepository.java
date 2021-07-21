package com.fpt.main.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fpt.main.entity.Offer;

public interface OfferRepository extends JpaRepository<Offer, Long> {
}
