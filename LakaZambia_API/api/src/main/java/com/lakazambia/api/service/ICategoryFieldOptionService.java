package com.lakazambia.api.service;

import java.util.List;

import com.lakazambia.api.model.CategoryFieldOption;

public interface ICategoryFieldOptionService {
	
	boolean createCategoryFieldOption(CategoryFieldOption c);
	CategoryFieldOption getCategoryFieldOptionById(int id);
	List<CategoryFieldOption> getAllCategoryFieldOptions();
	void updateCategoryFieldOption(CategoryFieldOption c);

}
