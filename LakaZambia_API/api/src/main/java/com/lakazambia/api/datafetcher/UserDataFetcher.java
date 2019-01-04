package com.lakazambia.api.datafetcher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lakazambia.api.dao.IUserDao;
import com.lakazambia.api.model.User;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class UserDataFetcher implements DataFetcher<List<User>>{

	
	@Autowired
	private IUserDao userdao; 
	@Override
	public List<User> get(DataFetchingEnvironment environment) {
		// TODO Auto-generated method stub
		return userdao.findAll();
	}
	
}
