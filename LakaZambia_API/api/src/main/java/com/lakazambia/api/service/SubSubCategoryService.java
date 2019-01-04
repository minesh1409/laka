package com.lakazambia.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lakazambia.api.dao.ISubSubCategory;
import com.lakazambia.api.model.SubSubCategory;

@Service
public class SubSubCategoryService implements ISubSubCAtegory{
	
	@Autowired
	private ISubSubCategory subsubcategory;

	@Override
	public boolean createSubSubCategory(SubSubCategory c) {
		// TODO Auto-generated method stub
		subsubcategory.createSubSubCategory(c);
		return true;
	}

	@Override
	public SubSubCategory getSubSubCategoryById(int id) {
		// TODO Auto-generated method stub
		return subsubcategory.getSubSubCategoryById(id);
	}

	@Override
	public List<SubSubCategory> getAllSubSubCategories() {
		// TODO Auto-generated method stub
		return subsubcategory.getAllSubSubCategories();
	}

	@Override
	public void updateSubSubCategory(SubSubCategory c) {
		// TODO Auto-generated method stub
		subsubcategory.updateSubSubCategory(c);
	}

	@Override
	public List<SubSubCategory> getSubSubCatByCatId(int SubCatid) {
		// TODO Auto-generated method stub
		return subsubcategory.getSubSubCatByCatId(SubCatid);
	}

}
