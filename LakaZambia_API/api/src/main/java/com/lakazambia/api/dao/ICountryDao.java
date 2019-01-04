package com.lakazambia.api.dao;

import java.util.List;

import com.lakazambia.api.model.Country;

public interface ICountryDao {

	void createCountry(Country u);

	List<Country> getAllCountries();

	void updateCountry(Country u);

	Country getCountryById(int CountryId);

}
