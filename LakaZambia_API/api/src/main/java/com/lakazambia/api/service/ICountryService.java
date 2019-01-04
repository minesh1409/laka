package com.lakazambia.api.service;

import java.util.List;

import com.lakazambia.api.model.Country;

public interface ICountryService {

	boolean createCountry(Country c);

	Country getCountryById(int id);

	List<Country> getAllContries();

	void updateCountry(Country c);

}
