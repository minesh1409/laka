package com.lakazambia.api.dao;

import java.util.List;

import com.lakazambia.api.model.OrderTransaction;

public interface IOrderTransactionDao {
	
	void createOrderTransaction(OrderTransaction u);

	List<OrderTransaction> getAllOrderTransactions();

	void updateOrderTransaction(OrderTransaction u);

	OrderTransaction getOrderTransactionById(int OrderTransactionId);

}
