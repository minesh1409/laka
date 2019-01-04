package com.lakazambia.api.service;

import java.util.List;

import com.lakazambia.api.model.OrderTransaction;

public interface IOrderTransactionService {
	
	boolean createOrderTransaction(OrderTransaction c);

	OrderTransaction getOrderTransactionById(int id);

	List<OrderTransaction> getAllOrderTransactions();

	void updateOrderTransaction(OrderTransaction c);

}
