package com.lakazambia.api.dao;

import java.text.ParseException;
import java.util.List;

import com.lakazambia.api.model.Customer;


public interface ICustomerDao {
	
	Customer findByCustomername(String Customername);

	Customer getCustomerById(Long CustomerId);

	Customer getCustomerByEmail(String email);

	Customer getCustomerByMobile(String mobile);

	void createCustomer(Customer u) throws ParseException;

	List<Customer> getAllCustomers();

	Customer doLogin(String name, String pswd);
	
	void updateCustomer(Customer u);

//	boolean doLogin(String name, String pswd);

	public void deleteCustomer(Long CustomerId);
	
	void updateCustomerStatus(Customer customer);
	


}
