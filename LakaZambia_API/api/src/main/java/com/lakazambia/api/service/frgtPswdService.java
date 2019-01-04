package com.lakazambia.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lakazambia.api.model.Customer;
import com.lakazambia.api.repository.frgtPasswordRepository;

@Service
public class frgtPswdService implements frgtPasswordService{
	
	@Autowired
	private frgtPasswordRepository frgtpswd;

	@Override
	public Optional<Customer> findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return frgtpswd.findByEmail(email);
	}

	@Override
	public Optional<Customer> findUserByResetToken(String resetToken) {
		// TODO Auto-generated method stub
		return frgtpswd.findByResetToken(resetToken);
	}

	@Override
	public void save(Customer customer) {
		// TODO Auto-generated method stub
		frgtpswd.save(customer);
	}

}
