package com.lakazambia.api.service;

import java.util.List;

import com.lakazambia.api.model.UserStore;

public interface IUserStoreService {
	
	boolean createUserStore(UserStore c);
	UserStore getUserStoreById(int id);
	List<UserStore> getAllUserStores();
	void updateUserStore(UserStore c);


}
