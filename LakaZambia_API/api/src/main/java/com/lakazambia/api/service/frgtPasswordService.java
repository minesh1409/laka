package com.lakazambia.api.service;

import java.util.Optional;

import com.lakazambia.api.model.Customer;

public interface frgtPasswordService {

	public Optional<Customer> findUserByEmail(String email);

	public Optional<Customer> findUserByResetToken(String resetToken);

	public void save(Customer customer);
}
