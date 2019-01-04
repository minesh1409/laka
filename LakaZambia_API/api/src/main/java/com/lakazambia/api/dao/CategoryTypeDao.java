package com.lakazambia.api.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.lakazambia.api.model.CategoryType;

@Transactional
@Repository
public class CategoryTypeDao implements ICategoryTypeDao {

	@Autowired
	private EntityManager entitymanger;

	@Override
	public void createCategoryType(CategoryType u) {
		// TODO Auto-generated method stub
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(sdf.format(date));
		u.setCreated_at(sdf.format(date));
		entitymanger.persist(u);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CategoryType> getAllCategoryTypes() {
		// TODO Auto-generated method stub
		return entitymanger.createQuery("FORM CategoryType").getResultList();
	}

	@Override
	public void updateCategoryType(CategoryType u) {
		// TODO Auto-generated method stub
		CategoryType ct = getCategoryTypeById(u.getType_id());
		ct.setName(u.getName());
		ct.setClass_name(u.getClass_name());
		ct.setDescription(u.getDescription());
		ct.setStatus(u.getStatus());
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(sdf.format(date));
		// u.setCreated_at(sdf.format(date));
		u.setUpdated_at(sdf.format(date));
		entitymanger.flush();
	}

	@Override
	public CategoryType getCategoryTypeById(int CategoryTypeId) {
		// TODO Auto-generated method stub
		return entitymanger.find(CategoryType.class, CategoryTypeId);
	}

}
