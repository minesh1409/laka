package com.lakazambia.api.datafetcher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lakazambia.api.dao.ICategoryDao;

import com.lakazambia.api.model.Category;


import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;


@Component
public class CategoryDataFetcher implements DataFetcher<List<Category>>{

	
	@Autowired
	private ICategoryDao categoryDao;
	@Override
	public List<Category> get(DataFetchingEnvironment environment) {
		// TODO Auto-generated method stub
		return categoryDao.findAll();
	}
}
