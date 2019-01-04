package com.lakazambia.api.dao;

import java.util.List;

import com.lakazambia.api.model.SubCategory;

public interface ISubCatDao {

	void createSubCategory(SubCategory u);

	List<SubCategory> getAllSubCategories();

	void updateSubCategory(SubCategory u);

	SubCategory getSubCategoryById(int SubCategoryId);
}
