package com.lakazambia.api.service;

import java.util.List;

import com.lakazambia.api.model.Order;

public interface IOrderService {
	
	boolean createOrder(Order c);

	Order getOrderById(int id);

	List<Order> getAllOrders();

	void updateOrder(Order c);

}
