package com.lakazambia.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lakazambia.api.dao.IOrderTransactionDao;
import com.lakazambia.api.model.OrderTransaction;

@Service
public class OrderTransactionService implements IOrderTransactionService{
	
	@Autowired
	private IOrderTransactionDao orderTransactionDao;

	@Override
	public boolean createOrderTransaction(OrderTransaction c) {
		// TODO Auto-generated method stub
		orderTransactionDao.createOrderTransaction(c);
		return true;
	}

	@Override
	public OrderTransaction getOrderTransactionById(int id) {
		// TODO Auto-generated method stub
		return orderTransactionDao.getOrderTransactionById(id);
	}

	@Override
	public List<OrderTransaction> getAllOrderTransactions() {
		// TODO Auto-generated method stub
		return orderTransactionDao.getAllOrderTransactions();
	}

	@Override
	public void updateOrderTransaction(OrderTransaction c) {
		// TODO Auto-generated method stub
		orderTransactionDao.updateOrderTransaction(c);
	}
	
	

}
