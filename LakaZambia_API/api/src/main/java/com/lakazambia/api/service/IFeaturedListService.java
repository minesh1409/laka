package com.lakazambia.api.service;

import java.util.List;

import com.lakazambia.api.model.FeaturedList;


public interface IFeaturedListService {

	boolean createfeaturedList(FeaturedList c);

	FeaturedList getfeaturedListById(int id);

	List<FeaturedList> getAllfeaturedLists();

	void updatefeaturedList(FeaturedList c);
}
