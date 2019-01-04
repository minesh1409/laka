package com.lakazambia.selfcare.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.lakazambia.selfcare.model.User;

/**
 * User repository for CRUD operations.
 */
public interface UserRepository extends JpaRepository<User,Long> {
	
	User findByUsername(String username);
}
