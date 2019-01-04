package com.lakazambia.api.service;

import java.util.List;

import com.lakazambia.api.model.ListingState;

public interface IListingStateService {
	
	boolean createListingState(ListingState c);

	ListingState getListingStateById(int id);

	List<ListingState> getAllListingStates();

	void updateListingState(ListingState c);

}
