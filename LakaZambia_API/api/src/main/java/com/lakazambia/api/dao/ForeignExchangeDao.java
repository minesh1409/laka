package com.lakazambia.api.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lakazambia.api.model.ForeignExchange;

@Transactional
@Repository
public class ForeignExchangeDao implements IForeignExchangeDao{
	
	
	@Autowired
	private EntityManager entitymanager;

	@SuppressWarnings("unchecked")
	@Override
	public List<ForeignExchange> getExchage() {
		// TODO Auto-generated method stub
		return entitymanager.createQuery("FROM ForeignExchange").getResultList();
	}
	
	
	

}
