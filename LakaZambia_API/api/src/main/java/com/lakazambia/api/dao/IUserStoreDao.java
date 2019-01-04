package com.lakazambia.api.dao;

import java.util.List;

import com.lakazambia.api.model.UserStore;

public interface IUserStoreDao {
	

	void createUserStore(UserStore  u);
	 List<UserStore> getAllUserStores();
	 void updateUserStore(UserStore u);
	 UserStore getUserStoreById(int storeId);


}
