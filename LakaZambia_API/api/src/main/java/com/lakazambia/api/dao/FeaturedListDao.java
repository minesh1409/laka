package com.lakazambia.api.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lakazambia.api.model.FeaturedList;

@Transactional
@Repository
public class FeaturedListDao implements IFeaturedListDao {

	@Autowired
	private EntityManager entitymanager;

	@Override
	public void createfeaturedList(FeaturedList u) {
		// TODO Auto-generated method stub
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(sdf.format(date));
		u.setCreated_at(sdf.format(date));
		entitymanager.persist(u);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FeaturedList> getAllfeaturedLists() {
		// TODO Auto-generated method stub
		return entitymanager.createQuery("FROM FeaturedList").getResultList();
	}

	@Override
	public void updatefeaturedList(FeaturedList u) {
		// TODO Auto-generated method stub
		FeaturedList fl = getfeaturedListById(u.getFeatured_id());
		fl.setFeatured_name(u.getFeatured_name());
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(sdf.format(date));
		// u.setCreated_at(sdf.format(date));
		fl.setUpdated_at(sdf.format(date));
		entitymanager.flush();
	}

	@Override
	public FeaturedList getfeaturedListById(int featuredListId) {
		// TODO Auto-generated method stub
		return entitymanager.find(FeaturedList.class, featuredListId);
	}

}
