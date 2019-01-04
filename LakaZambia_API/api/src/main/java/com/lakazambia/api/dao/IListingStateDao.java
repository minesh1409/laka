package com.lakazambia.api.dao;

import java.util.List;

import com.lakazambia.api.model.ListingState;

public interface IListingStateDao {
	
	void createListingState(ListingState u);

	List<ListingState> getAllListingStates();

	void updateListingState(ListingState u);

	ListingState getListingStateById(int ListingStateId);

}
