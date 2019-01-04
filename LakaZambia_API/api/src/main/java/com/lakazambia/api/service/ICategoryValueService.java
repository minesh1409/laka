package com.lakazambia.api.service;

import java.util.List;

import com.lakazambia.api.model.CategoryFieldValue;

public interface ICategoryValueService {
	
	boolean createCategoryFieldValue(CategoryFieldValue c);
	CategoryFieldValue getCategoryFieldValueById(int id);
	List<CategoryFieldValue> getAllContries();
	void updateCategoryFieldValue(CategoryFieldValue c);

}
