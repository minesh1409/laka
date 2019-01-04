package com.lakazambia.api.service;

import java.util.List;

import com.lakazambia.api.model.Currency;

public interface ICurrencyService {

	
	boolean createCurrency(Currency c);
	Currency getCurrencyById(int id);
	List<Currency> getAllCurrencies();
	void updateCurrency(Currency c);
	
}
