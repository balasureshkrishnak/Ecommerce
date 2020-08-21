package com.hcl.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.ecommerce.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	public Optional<User> findByUserId(Integer userId);

}
