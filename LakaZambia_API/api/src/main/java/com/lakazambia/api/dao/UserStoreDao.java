package com.lakazambia.api.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lakazambia.api.model.UserStore;

@Transactional
@Repository
public class UserStoreDao implements IUserStoreDao {

	@Autowired
	private EntityManager entitymanager;

	@Override
	public void createUserStore(UserStore u) {
		// TODO Auto-generated method stub
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(sdf.format(date));
		u.setCreated_at(sdf.format(date));
		entitymanager.persist(u);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserStore> getAllUserStores() {
		// TODO Auto-generated method stub
		return entitymanager.createQuery("FROM UserStore").getResultList();
	}

	@Override
	public void updateUserStore(UserStore u) {
		// TODO Auto-generated method stub
		UserStore us = getUserStoreById(u.getStore_id());
		us.setSlug(u.getSlug());
		us.setStore_name(u.getStore_name());
		us.setCompany_name(u.getCompany_name());
		us.setCompany_no(u.getCompany_no());
		us.setVat(u.getVat());
		us.setStatus(u.getStatus());
		 DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			System.out.println(sdf.format(date));
			//u.setCreated_at(sdf.format(date));
		us.setUpdated_at(sdf.format(date));
		entitymanager.flush();
	}

	@Override
	public UserStore getUserStoreById(int storeId) {
		// TODO Auto-generated method stub
		return entitymanager.find(UserStore.class, storeId);
	}

}
