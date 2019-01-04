package com.lakazambia.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lakazambia.api.dao.IUserStoreDao;
import com.lakazambia.api.model.UserStore;

@Service
public class UserStoreService implements IUserStoreService{
	
	@Autowired
	private IUserStoreDao userstoredao;

	@Override
	public boolean createUserStore(UserStore c) {
		// TODO Auto-generated method stub
		userstoredao.createUserStore(c);
		return true;
	}

	@Override
	public UserStore getUserStoreById(int id) {
		// TODO Auto-generated method stub
		return userstoredao.getUserStoreById(id);
	}

	@Override
	public List<UserStore> getAllUserStores() {
		// TODO Auto-generated method stub
		return userstoredao.getAllUserStores();
	}

	@Override
	public void updateUserStore(UserStore c) {
		// TODO Auto-generated method stub
		userstoredao.updateUserStore(c);
	}

}
