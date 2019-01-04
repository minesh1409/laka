package com.lakazambia.api.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lakazambia.api.dao.ICustomerDao;
import com.lakazambia.api.model.Customer;

@Service
public class CustomerService implements ICustomerService{
	
	
	@Autowired
	private ICustomerDao customerDao;

	@Override
	public boolean createCustomer(Customer u) throws ParseException {
		// TODO Auto-generated method stub
		customerDao.createCustomer(u);
		return true;
	}

	@Override
	public Customer getCustomerById(Long id) {
		// TODO Auto-generated method stub
		return customerDao.getCustomerById(id);
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerDao.getAllCustomers();
	}

	@Override
	public void updateCustomer(Customer u) {
		// TODO Auto-generated method stub
		customerDao.updateCustomer(u);
	}

	
	@Override
	public void deleteCustomer(Long CustomerId) {
		// TODO Auto-generated method stub
		customerDao.deleteCustomer(CustomerId);
	}

	@Override
	public Customer doLogin(String name, String pswd) {
		// TODO Auto-generated method stub
		return customerDao.doLogin(name, pswd);
	}

	@Override
	public void updateStatus(Customer cust) {
		// TODO Auto-generated method stub
		customerDao.updateCustomerStatus(cust);
	}
	
	

	
}
