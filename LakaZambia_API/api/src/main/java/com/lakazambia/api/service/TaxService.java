package com.lakazambia.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lakazambia.api.dao.ITaxDao;
import com.lakazambia.api.model.Tax;

@Service
public class TaxService implements ITaxService{
	
	
	@Autowired
	private ITaxDao taxDao;

	@Override
	public boolean createTax(Tax c) {
		// TODO Auto-generated method stub
		taxDao.createTax(c);
		return true;
	}

	@Override
	public Tax getTaxById(int id) {
		// TODO Auto-generated method stub
		return taxDao.getTaxById(id);
	}

	@Override
	public List<Tax> getAllTaxes() {
		// TODO Auto-generated method stub
		return taxDao.getAllTaxes();
	}

	@Override
	public void updateTax(Tax c) {
		// TODO Auto-generated method stub
		taxDao.updateTax(c);
	}

}
