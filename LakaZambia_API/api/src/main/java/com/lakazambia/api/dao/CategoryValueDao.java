package com.lakazambia.api.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lakazambia.api.model.CategoryFieldValue;

@Transactional
@Repository
public class CategoryValueDao implements ICategoryValueDao {

	@Autowired
	private EntityManager entitymanager;

	@Override
	public void createCategoryFieldValue(CategoryFieldValue u) {
		// TODO Auto-generated method stub
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(sdf.format(date));
		u.setCreated_at(sdf.format(date));
		entitymanager.persist(u);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CategoryFieldValue> getAllCategoryFieldValues() {
		// TODO Auto-generated method stub
		return entitymanager.createQuery("FROM CategoryFieldValue").getResultList();
	}

	@Override
	public void updateCategoryFieldValue(CategoryFieldValue u) {
		// TODO Auto-generated method stub
		CategoryFieldValue value = getCategoryFieldValueById(u.getValue_id());
		value.setValue(u.getValue());
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(sdf.format(date));
		// u.setCreated_at(sdf.format(date));
		u.setUpdated_at(sdf.format(date));
		entitymanager.flush();
	}

	@Override
	public CategoryFieldValue getCategoryFieldValueById(int CategoryFieldValueId) {
		// TODO Auto-generated method stub
		return entitymanager.find(CategoryFieldValue.class, CategoryFieldValueId);
	}

}
