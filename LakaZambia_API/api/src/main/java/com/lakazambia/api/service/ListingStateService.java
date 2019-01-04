package com.lakazambia.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lakazambia.api.dao.IListingStateDao;
import com.lakazambia.api.model.ListingState;

@Service
public class ListingStateService implements IListingStateService{
	
	
	@Autowired
	private IListingStateDao listingStateDao;

	@Override
	public boolean createListingState(ListingState c) {
		// TODO Auto-generated method stub
		listingStateDao.createListingState(c);
		return true;
	}

	@Override
	public ListingState getListingStateById(int id) {
		// TODO Auto-generated method stub
		return listingStateDao.getListingStateById(id);
	}

	@Override
	public List<ListingState> getAllListingStates() {
		// TODO Auto-generated method stub
		return listingStateDao.getAllListingStates();
	}

	@Override
	public void updateListingState(ListingState c) {
		// TODO Auto-generated method stub
		listingStateDao.updateListingState(c);
	}

}
