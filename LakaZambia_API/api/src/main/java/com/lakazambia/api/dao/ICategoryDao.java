package com.lakazambia.api.dao;

import java.util.List;

import com.lakazambia.api.model.Category;


public interface ICategoryDao {

	void createCategory(Category c);

	List<Category> getAllCategories();

	void updateCategory(Category c);

	Category getCategoryById(int categoryId);

	
	//FOR RETHINK
	 
	List<Category> findAll();
			
}
