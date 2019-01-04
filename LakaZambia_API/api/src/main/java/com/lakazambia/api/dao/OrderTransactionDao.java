package com.lakazambia.api.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lakazambia.api.model.OrderTransaction;

@Transactional
@Repository
public class OrderTransactionDao implements IOrderTransactionDao {

	@Autowired
	private EntityManager entitymanager;

	@Override
	public void createOrderTransaction(OrderTransaction u) {
		// TODO Auto-generated method stub
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(sdf.format(date));
		u.setCreated_at(sdf.format(date));
		entitymanager.persist(u);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderTransaction> getAllOrderTransactions() {
		// TODO Auto-generated method stub
		return entitymanager.createQuery("FROM OrderTransaction").getResultList();
	}

	@Override
	public void updateOrderTransaction(OrderTransaction u) {
		// TODO Auto-generated method stub
		OrderTransaction ot = getOrderTransactionById(u.getTransaction_id());
		ot.setGateway(u.getGateway());
		ot.setType(u.getType());
		ot.setGateway_response(u.getGateway_response());
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(sdf.format(date));
		// u.setCreated_at(sdf.format(date));
		u.setUpdated_at(sdf.format(date));
		entitymanager.flush();
	}

	@Override
	public OrderTransaction getOrderTransactionById(int OrderTransactionId) {
		// TODO Auto-generated method stub
		return entitymanager.find(OrderTransaction.class, OrderTransactionId);
	}

}
