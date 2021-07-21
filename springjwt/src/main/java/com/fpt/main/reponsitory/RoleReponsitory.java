package com.fpt.main.reponsitory;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fpt.main.entity.ERole;
import com.fpt.main.entity.Role;

@Repository
public interface RoleReponsitory extends JpaRepository<Role, Long>{
	Optional<Role> findByName(ERole name);
}
