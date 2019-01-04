package com.lakazambia.api.dao;

import java.util.List;

import com.lakazambia.api.model.CategoryType;

public interface ICategoryTypeDao {
	
	void createCategoryType(CategoryType  u);
	 List<CategoryType> getAllCategoryTypes();
	 void updateCategoryType(CategoryType u);
	 CategoryType getCategoryTypeById(int CategoryTypeId);

}
