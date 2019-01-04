package com.lakazambia.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lakazambia.api.dao.ICategoryValueDao;
import com.lakazambia.api.model.CategoryFieldValue;

@Service
public class CategoryValueService implements ICategoryValueService{
	
	@Autowired
	private ICategoryValueDao categoryValueDao;

	@Override
	public boolean createCategoryFieldValue(CategoryFieldValue c) {
		// TODO Auto-generated method stub
		categoryValueDao.createCategoryFieldValue(c);
		return true;
	}

	@Override
	public CategoryFieldValue getCategoryFieldValueById(int id) {
		// TODO Auto-generated method stub
		return categoryValueDao.getCategoryFieldValueById(id);
	}

	@Override
	public List<CategoryFieldValue> getAllContries() {
		// TODO Auto-generated method stub
		return categoryValueDao.getAllCategoryFieldValues();
	}

	@Override
	public void updateCategoryFieldValue(CategoryFieldValue c) {
		// TODO Auto-generated method stub
		categoryValueDao.updateCategoryFieldValue(c);
	}

}
