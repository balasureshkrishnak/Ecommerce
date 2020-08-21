package com.hcl.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.ecommerce.model.User;


public interface UserRepo extends JpaRepository<User, Integer> {
	User findByEmail(String email);
	User findByEmailAndPassword(String email, String password);
}
