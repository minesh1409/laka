package com.lakazambia.api.service;

import java.util.List;

import com.lakazambia.api.model.Tax;

public interface ITaxService {
	
	
	boolean createTax(Tax c);

	Tax getTaxById(int id);

	List<Tax> getAllTaxes();

	void updateTax(Tax c);

}
