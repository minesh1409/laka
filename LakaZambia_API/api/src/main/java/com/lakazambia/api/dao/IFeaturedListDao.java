package com.lakazambia.api.dao;

import java.util.List;

import com.lakazambia.api.model.FeaturedList;


public interface IFeaturedListDao {

	void createfeaturedList(FeaturedList u);

	List<FeaturedList> getAllfeaturedLists();

	void updatefeaturedList(FeaturedList u);

	FeaturedList getfeaturedListById(int featuredListId);
}
