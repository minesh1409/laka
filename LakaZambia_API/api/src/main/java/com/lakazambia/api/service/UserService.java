package com.lakazambia.api.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lakazambia.api.dao.IUserDao;
import com.lakazambia.api.model.User;

@Service
public class UserService implements IUserService{

	
	@Autowired
	private IUserDao userdao;
	@Override
	public boolean createUser(User u) throws ParseException {
		// TODO Auto-generated method stub
		userdao.createUser(u);
		return true;
	}

	@Override
	public User getUserById(Long id) {
		// TODO Auto-generated method stub
		return userdao.getUserById(id);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userdao.getAllUsers();
	}

	@Override
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userdao.getUserByEmail(email);
	}

	@Override
	public User getUserByMobile(String mobile) {
		// TODO Auto-generated method stub
		return userdao.getUserByMobile(mobile);
	}

	@Override
	public boolean UserExists(String email) {
		// TODO Auto-generated method stub
		return userdao.UserExists(email);
	}

	@Override
	public void updateUser(User u) {
		// TODO Auto-generated method stub
		System.out.println("In service");
		userdao.updateUser(u);
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return userdao.findByUsername(username);
	}

	@Override
	public User doLogin(String name, String pswd) {
		// TODO Auto-generated method stub
		return userdao.doLogin(name, pswd);
		
	}

	/*@Override
	public boolean Login(String name, String pswd) {
		// TODO Auto-generated method stub
		return false;
	}*/

	
}
