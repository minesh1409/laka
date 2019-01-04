package com.lakazambia.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lakazambia.api.model.Customer;


public interface frgtPasswordRepository extends JpaRepository<Customer, Long>{
	
	 Optional<Customer> findByEmail(String email);
	 Optional<Customer> findByResetToken(String resetToken);

}
