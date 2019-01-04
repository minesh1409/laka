package com.lakazambia.api.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lakazambia.api.model.SubCategory;

@Transactional
@Repository
public class SubCatDao implements ISubCatDao{
	
	
	@Autowired
	private EntityManager em;

	@Override
	public void createSubCategory(SubCategory u) {
		// TODO Auto-generated method stub
		em.persist(u);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SubCategory> getAllSubCategories() {
		// TODO Auto-generated method stub
		return em.createQuery("FROM SubCategory").getResultList();
	}

	@Override
	public void updateSubCategory(SubCategory u) {
		// TODO Auto-generated method stub
		SubCategory sc=getSubCategoryById(u.getSubcat_id());
		sc.setName(u.getName());
		sc.setShort_name(u.getShort_name());
		
		em.flush();
	}

	@Override
	public SubCategory getSubCategoryById(int SubCategoryId) {
		// TODO Auto-generated method stub
		return em.find(SubCategory.class,SubCategoryId);
	}

}
