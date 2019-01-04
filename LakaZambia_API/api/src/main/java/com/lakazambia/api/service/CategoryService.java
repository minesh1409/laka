package com.lakazambia.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lakazambia.api.dao.ICategoryDao;
import com.lakazambia.api.model.Category;

@Service
public class CategoryService implements ICategoryService{
	
	@Autowired
	private ICategoryDao categorydao;

	@Override
	public boolean createCategory(Category c) {
		// TODO Auto-generated method stub
		categorydao.createCategory(c);
		return true;
	}

	@Override
	public Category getCategoryById(int id) {
		// TODO Auto-generated method stub
		return categorydao.getCategoryById(id);
	}

	@Override
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return categorydao.getAllCategories();
	}

	@Override
	public void updateCategory(Category c) {
		// TODO Auto-generated method stub
		categorydao.updateCategory(c);
	}

}
