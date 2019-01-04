package com.lakazambia.api.dao;

import java.util.List;

import com.lakazambia.api.model.Currency;

public interface ICurrencyDao {
	
	void createCurrency(Currency  u);
	 List<Currency> getAllCurrencies();
	 void updateCurrency(Currency u);
	 Currency getCurrencyById(int CurrencyId);

}
