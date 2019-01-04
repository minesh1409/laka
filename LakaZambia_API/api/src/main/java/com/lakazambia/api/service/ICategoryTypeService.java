package com.lakazambia.api.service;

import java.util.List;

import com.lakazambia.api.model.CategoryType;

public interface ICategoryTypeService {
	
	boolean createCategoryType(CategoryType c);
	CategoryType getCategoryTypeById(int id);
	List<CategoryType> getAllCategoryTypes();
	void updateCategoryType(CategoryType c);

}
