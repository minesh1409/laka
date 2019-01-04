package com.lakazambia.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lakazambia.api.dao.IFeaturedListDao;
import com.lakazambia.api.model.FeaturedList;

@Service
public class FeaturedListService implements IFeaturedListService{
	
	
	
	@Autowired
	private IFeaturedListDao featuredListDao;

	@Override
	public boolean createfeaturedList(FeaturedList c) {
		// TODO Auto-generated method stub
		featuredListDao.createfeaturedList(c);
		return true;
	}

	@Override
	public FeaturedList getfeaturedListById(int id) {
		// TODO Auto-generated method stub
		return featuredListDao.getfeaturedListById(id);
	}

	@Override
	public List<FeaturedList> getAllfeaturedLists() {
		// TODO Auto-generated method stub
		return featuredListDao.getAllfeaturedLists();
	}

	@Override
	public void updatefeaturedList(FeaturedList c) {
		// TODO Auto-generated method stub
		featuredListDao.updatefeaturedList(c);
	}
	
	
	

}
