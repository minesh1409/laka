package com.lakazambia.api.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lakazambia.api.model.Country;

@Transactional
@Repository
public class CountryDao implements ICountryDao{
	
	
	@Autowired
	private EntityManager entitymanager;

	@Override
	public void createCountry(Country u) {
		// TODO Auto-generated method stub
		
		entitymanager.persist(u);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Country> getAllCountries() {
		// TODO Auto-generated method stub
		return entitymanager.createQuery("FROM Country").getResultList();
	}

	@Override
	public void updateCountry(Country u) {
		// TODO Auto-generated method stub
		Country con=getCountryById(u.getCountry_id());
		con.setName(u.getName());
		con.setCode(u.getCode());
		con.setStatus(u.getStatus());
		con.setCreated_at(u.getCreated_at());
		con.setUpdated_at(u.getUpdated_at());
	}

	@Override
	public Country getCountryById(int CountryId) {
		// TODO Auto-generated method stub
		return entitymanager.find(Country.class,CountryId);
	}

}
