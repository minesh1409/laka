package com.lakazambia.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lakazambia.api.dao.ICategoryOptionDao;
import com.lakazambia.api.model.CategoryFieldOption;

@Service
public class CategoryFieldOptionService implements ICategoryFieldOptionService{
	
	@Autowired
	private ICategoryOptionDao categoryOptionDao;

	@Override
	public boolean createCategoryFieldOption(CategoryFieldOption c) {
		// TODO Auto-generated method stub
		categoryOptionDao.createCategoryFieldOption(c);
		return true;
	}

	@Override
	public CategoryFieldOption getCategoryFieldOptionById(int id) {
		// TODO Auto-generated method stub
		return categoryOptionDao.getCategoryFieldOptionById(id);
	}

	@Override
	public List<CategoryFieldOption> getAllCategoryFieldOptions() {
		// TODO Auto-generated method stub
		return categoryOptionDao.getAllCategoryFieldOptions();
	}

	@Override
	public void updateCategoryFieldOption(CategoryFieldOption c) {
		// TODO Auto-generated method stub
		categoryOptionDao.updateCategoryFieldOption(c);
	}

}
