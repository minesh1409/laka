package com.lakazambia.api.dao;

import java.util.List;

import com.lakazambia.api.model.CategoryField;

public interface ICategoryFieldDao {
	
	
	void createCategoryField(CategoryField  u);
	 List<CategoryField> getAllCategoryFields();
	 void updateCategoryField(CategoryField u);
	 CategoryField getCategoryFieldById(int CategoryFieldId);

}
