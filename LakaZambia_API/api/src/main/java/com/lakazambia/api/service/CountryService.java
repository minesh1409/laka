package com.lakazambia.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lakazambia.api.dao.ICountryDao;
import com.lakazambia.api.model.Country;

@Service
public class CountryService implements ICountryService{
	
	@Autowired
	private ICountryDao countryDao;

	@Override
	public boolean createCountry(Country c) {
		// TODO Auto-generated method stub
		countryDao.createCountry(c);
		return true;
	}

	@Override
	public Country getCountryById(int id) {
		// TODO Auto-generated method stub
		return countryDao.getCountryById(id);
	}

	@Override
	public List<Country> getAllContries() {
		// TODO Auto-generated method stub
		return countryDao.getAllCountries();
	}

	@Override
	public void updateCountry(Country c) {
		// TODO Auto-generated method stub
		countryDao.updateCountry(c);
	}

}
