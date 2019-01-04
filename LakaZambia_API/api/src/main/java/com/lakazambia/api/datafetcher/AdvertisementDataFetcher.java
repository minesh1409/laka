package com.lakazambia.api.datafetcher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lakazambia.api.dao.IAdvertisementDao;

import com.lakazambia.api.model.Advertisement;


import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;


@Component
public class AdvertisementDataFetcher implements DataFetcher<List<Advertisement>>{

	
	@Autowired
	private IAdvertisementDao advertisementDao; 
	@Override
	public List<Advertisement> get(DataFetchingEnvironment environment) {
		// TODO Auto-generated method stub
		return advertisementDao.findAll();
	}
}
