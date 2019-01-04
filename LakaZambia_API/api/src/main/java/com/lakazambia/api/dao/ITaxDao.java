package com.lakazambia.api.dao;

import java.util.List;

import com.lakazambia.api.model.Tax;

public interface ITaxDao {
	
	
	void createTax(Tax u);

	List<Tax> getAllTaxes();

	void updateTax(Tax u);

	Tax getTaxById(int TaxId);

}
