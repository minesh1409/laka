package com.lakazambia.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lakazambia.api.dao.ISubCatDao;
import com.lakazambia.api.model.SubCategory;

@Service
public class SubCatService implements ISubCatService {
	
	
	@Autowired
	private ISubCatDao subcatdao;

	@Override
	public boolean createSubCategory(SubCategory c) {
		// TODO Auto-generated method stub
		subcatdao.createSubCategory(c);
		return true;
	}

	@Override
	public SubCategory getSubCategoryById(int id) {
		// TODO Auto-generated method stub
		return subcatdao.getSubCategoryById(id);
	}

	@Override
	public List<SubCategory> getAllSubCategories() {
		// TODO Auto-generated method stub
		return subcatdao.getAllSubCategories();
	}

	@Override
	public void updateSubCategory(SubCategory c) {
		// TODO Auto-generated method stub
		subcatdao.updateSubCategory(c);
	}

}
