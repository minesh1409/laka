package com.lakazambia.api.service;

import java.util.List;

import com.lakazambia.api.model.Category;

public interface ICategoryService {
	
	boolean createCategory(Category c);
	Category getCategoryById(int id);
	List<Category> getAllCategories();
	void updateCategory(Category c);

}
