package com.lakazambia.api.service;

import java.text.ParseException;
import java.util.List;

import com.lakazambia.api.model.Customer;


public interface ICustomerService {

	boolean createCustomer(Customer u) throws ParseException;

	// boolean doLogin(String name,String pswd);
	Customer getCustomerById(Long id);

	List<Customer> getAllCustomers();

	void updateCustomer(Customer u);

//	boolean doLogin(String name, String pswd);

	public void deleteCustomer(Long CustomerId);
	
	Customer doLogin(String name,String pswd);
	
	void updateStatus(Customer cust);

}
