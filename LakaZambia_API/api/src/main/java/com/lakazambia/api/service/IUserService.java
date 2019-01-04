package com.lakazambia.api.service;

import java.text.ParseException;
import java.util.List;

import com.lakazambia.api.model.User;

public interface IUserService {
	
	boolean createUser(User u) throws ParseException;
//	boolean doLogin(String name,String pswd);
	User getUserById(Long id);
	List<User> getAllUsers();
	User getUserByEmail(String email);
  	User getUserByMobile(String mobile);
  	boolean UserExists(String email);
	void updateUser(User u);
	User findByUsername(String username);
	User doLogin(String name,String pswd);

}
