package com.lakazambia.api.dao;

import java.util.List;

import com.lakazambia.api.model.CategoryFieldOption;

public interface ICategoryOptionDao {
	
	void createCategoryFieldOption(CategoryFieldOption u);

	List<CategoryFieldOption> getAllCategoryFieldOptions();

	void updateCategoryFieldOption(CategoryFieldOption u);

	CategoryFieldOption getCategoryFieldOptionById(int CategoryFieldOptionId);

}
