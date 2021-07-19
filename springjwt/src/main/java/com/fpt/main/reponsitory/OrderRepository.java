package com.fpt.main.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fpt.main.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
