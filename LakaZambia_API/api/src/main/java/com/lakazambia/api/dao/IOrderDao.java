package com.lakazambia.api.dao;

import java.util.List;

import com.lakazambia.api.model.Order;

public interface IOrderDao {
	
	void createOrder(Order u);

	List<Order> getAllOrders();

	void updateOrder(Order u);

	Order getOrderById(int OrderId);

}
