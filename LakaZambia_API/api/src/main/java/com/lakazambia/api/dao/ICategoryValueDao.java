package com.lakazambia.api.dao;

import java.util.List;

import com.lakazambia.api.model.CategoryFieldValue;

public interface ICategoryValueDao {
	
	void createCategoryFieldValue(CategoryFieldValue u);

	List<CategoryFieldValue> getAllCategoryFieldValues();

	void updateCategoryFieldValue(CategoryFieldValue u);

	CategoryFieldValue getCategoryFieldValueById(int CategoryFieldValueId);

}
