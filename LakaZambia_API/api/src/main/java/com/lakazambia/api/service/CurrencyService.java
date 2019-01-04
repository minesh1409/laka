package com.lakazambia.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lakazambia.api.dao.ICurrencyDao;
import com.lakazambia.api.model.Currency;

@Service
public class CurrencyService implements ICurrencyService{
	
	
	
	@Autowired
	private ICurrencyDao currencyDao;
	

	@Override
	public boolean createCurrency(Currency c) {
		// TODO Auto-generated method stub
		currencyDao.createCurrency(c);
		return true;
	}

	@Override
	public Currency getCurrencyById(int id) {
		// TODO Auto-generated method stub
		return currencyDao.getCurrencyById(id);
	}

	@Override
	public List<Currency> getAllCurrencies() {
		// TODO Auto-generated method stub
		return currencyDao.getAllCurrencies();
	}

	@Override
	public void updateCurrency(Currency c) {
		// TODO Auto-generated method stub
		currencyDao.updateCurrency(c);
	}
	
	
	

}
