package com.lakazambia.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.lakazambia.api.dao.ICategoryTypeDao;
import com.lakazambia.api.model.CategoryType;

@Service
public class CategoryTypeService implements ICategoryTypeService{
	
	
	@Autowired
	private ICategoryTypeDao categorytypedao;

	@Override
	public boolean createCategoryType(CategoryType c) {
		// TODO Auto-generated method stub
		categorytypedao.createCategoryType(c);
		return true;
	}

	@Override
	public CategoryType getCategoryTypeById(int id) {
		// TODO Auto-generated method stub
		return categorytypedao.getCategoryTypeById(id);
	}

	@Override
	public List<CategoryType> getAllCategoryTypes() {
		// TODO Auto-generated method stub
		return categorytypedao.getAllCategoryTypes();
	}

	@Override
	public void updateCategoryType(CategoryType c) {
		// TODO Auto-generated method stub
		categorytypedao.updateCategoryType(c);
	}

}
