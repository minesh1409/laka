package com.lakazambia.api.service;

import java.util.List;

import com.lakazambia.api.model.CategoryField;

public interface ICategoryFieldService {

	
	boolean createCategoryField(CategoryField cf);
	CategoryField getCategoryFieldById(int id);
	List<CategoryField> getAllCategoryFields();
	void updateCategoryField(CategoryField cf);
}
