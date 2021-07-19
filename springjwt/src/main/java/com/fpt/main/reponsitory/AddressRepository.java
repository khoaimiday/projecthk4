package com.fpt.main.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fpt.main.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
