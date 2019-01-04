package com.lakazambia.api.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lakazambia.api.model.Order;

@Transactional
@Repository
public class OrderDao implements IOrderDao {

	@Autowired
	private EntityManager entitymanager;

	@Override
	public void createOrder(Order u) {
		// TODO Auto-generated method stub
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(sdf.format(date));
		u.setCreated_at(sdf.format(date));
		entitymanager.persist(u);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return entitymanager.createQuery("FROM Order").getResultList();
	}

	@Override
	public void updateOrder(Order u) {
		// TODO Auto-generated method stub
		Order o = getOrderById(u.getOrder_id());
		o.setFirst_name(u.getFirst_name());
		o.setLast_name(u.getLast_name());
		o.setCompany_name(u.getCompany_name());
		o.setCompany_no(u.getCompany_no());
		o.setVat(u.getVat());
		o.setCity(u.getCity());
		o.setZip(u.getZip());
		o.setPhone(u.getPhone());
		o.setDiscount(u.getDiscount());
		o.setSubtotal(u.getSubtotal());
		o.setTotal(u.getTotal());
		o.setStatus(u.getStatus());
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(sdf.format(date));
		// u.setCreated_at(sdf.format(date));
		u.setUpdated_at(sdf.format(date));
		entitymanager.flush();
	}

	@Override
	public Order getOrderById(int OrderId) {
		// TODO Auto-generated method stub
		return entitymanager.find(Order.class, OrderId);
	}

}
