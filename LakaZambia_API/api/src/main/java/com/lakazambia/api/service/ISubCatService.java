package com.lakazambia.api.service;

import java.util.List;

import com.lakazambia.api.model.SubCategory;

public interface ISubCatService {

	
	boolean createSubCategory(SubCategory c);

	SubCategory getSubCategoryById(int id);

	List<SubCategory> getAllSubCategories();

	void updateSubCategory(SubCategory c);
}
