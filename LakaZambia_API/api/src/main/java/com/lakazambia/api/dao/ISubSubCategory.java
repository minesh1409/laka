package com.lakazambia.api.dao;

import java.util.List;

import com.lakazambia.api.model.SubSubCategory;

public interface ISubSubCategory {
	
	void createSubSubCategory(SubSubCategory u);

	List<SubSubCategory> getAllSubSubCategories();

	void updateSubSubCategory(SubSubCategory u);

	SubSubCategory getSubSubCategoryById(int SubSubCategoryId);

	List<SubSubCategory> getSubSubCatByCatId(int SubCatid);
}
