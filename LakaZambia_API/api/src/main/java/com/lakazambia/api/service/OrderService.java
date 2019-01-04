package com.lakazambia.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lakazambia.api.dao.IOrderDao;
import com.lakazambia.api.model.Order;

@Service
public class OrderService implements IOrderService{
	
	
	@Autowired
	private IOrderDao orderDao;

	@Override
	public boolean createOrder(Order c) {
		// TODO Auto-generated method stub
		orderDao.createOrder(c);
		return true;
	}

	@Override
	public Order getOrderById(int id) {
		// TODO Auto-generated method stub
		return orderDao.getOrderById(id);
	}

	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return orderDao.getAllOrders();
	}

	@Override
	public void updateOrder(Order c) {
		// TODO Auto-generated method stub
		orderDao.updateOrder(c);
	}

}
