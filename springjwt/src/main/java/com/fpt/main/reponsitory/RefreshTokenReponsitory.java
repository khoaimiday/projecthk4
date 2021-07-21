package com.fpt.main.reponsitory;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fpt.main.entity.RefreshToken;
import com.fpt.main.entity.User;

@Repository
public interface RefreshTokenReponsitory extends JpaRepository<RefreshToken, Long>{
	
	Optional<RefreshToken> findById(Long id);
	
	Optional<RefreshToken> findByToken(String token);

	int deleteByUser(User user);

}
