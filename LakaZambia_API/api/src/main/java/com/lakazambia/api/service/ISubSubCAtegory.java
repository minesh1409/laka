package com.lakazambia.api.service;

import java.util.List;

import com.lakazambia.api.model.SubSubCategory;

public interface ISubSubCAtegory {
	
	boolean createSubSubCategory(SubSubCategory c);

	SubSubCategory getSubSubCategoryById(int id);

	List<SubSubCategory> getAllSubSubCategories();

	void updateSubSubCategory(SubSubCategory c);
	
	List<SubSubCategory> getSubSubCatByCatId(int SubCatid);

}
