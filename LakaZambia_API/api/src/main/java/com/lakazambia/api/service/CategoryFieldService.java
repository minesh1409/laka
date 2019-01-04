package com.lakazambia.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lakazambia.api.dao.ICategoryFieldDao;
import com.lakazambia.api.model.CategoryField;

@Service
public class CategoryFieldService implements ICategoryFieldService{
	
	
	@Autowired
	private ICategoryFieldDao categoryFieldDao;

	@Override
	public boolean createCategoryField(CategoryField cf) {
		// TODO Auto-generated method stub
		categoryFieldDao.createCategoryField(cf);
		return true;
	}

	@Override
	public CategoryField getCategoryFieldById(int id) {
		// TODO Auto-generated method stub
		return categoryFieldDao.getCategoryFieldById(id);
	}

	@Override
	public List<CategoryField> getAllCategoryFields() {
		// TODO Auto-generated method stub
		return categoryFieldDao.getAllCategoryFields();
	}

	@Override
	public void updateCategoryField(CategoryField cf) {
		// TODO Auto-generated method stub
		categoryFieldDao.updateCategoryField(cf);
	}

}
