package com.lakazambia.api.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lakazambia.api.model.Currency;

@Transactional
@Repository
public class CurrencyDao implements ICurrencyDao {

	@Autowired
	private EntityManager entitymanager;

	@Override
	public void createCurrency(Currency u) {
		// TODO Auto-generated method stub
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(sdf.format(date));
		u.setCreated_at(sdf.format(date));

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Currency> getAllCurrencies() {
		// TODO Auto-generated method stub
		return entitymanager.createQuery("FROM Currency").getResultList();
	}

	@Override
	public void updateCurrency(Currency u) {
		// TODO Auto-generated method stub
		Currency cur = getCurrencyById(u.getCurrency_id());
		cur.setName(u.getName());
		cur.setSymbol(u.getSymbol());
		cur.setCode(u.getCode());
		cur.setStatus(u.getStatus());
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(sdf.format(date));
		// u.setCreated_at(sdf.format(date));
		cur.setUpdated_at(sdf.format(date));
		entitymanager.flush();
	}

	@Override
	public Currency getCurrencyById(int CurrencyId) {
		// TODO Auto-generated method stub
		return entitymanager.find(Currency.class, CurrencyId);
	}

}
