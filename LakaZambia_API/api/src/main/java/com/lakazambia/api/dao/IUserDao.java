package com.lakazambia.api.dao;

import java.text.ParseException;
import java.util.List;



import com.lakazambia.api.model.User;

public interface IUserDao {
	
	User findByUsername(String username);

	User getUserById(Long userId);

	User getUserByEmail(String email);

	User getUserByMobile(String mobile);

	void createUser(User u) throws ParseException;

	List<User> getAllUsers();

	boolean UserExists(String email);

	void updateUser(User u);

	User doLogin(String name, String pswd);

	// FOR RETHINK

	List<User> findAll();

	List<User> getUserByID(int uid);
}
