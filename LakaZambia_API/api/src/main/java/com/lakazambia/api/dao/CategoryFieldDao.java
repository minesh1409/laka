package com.lakazambia.api.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import javax.persistence.EntityManager;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lakazambia.api.model.CategoryField;

@Transactional
@Repository
public class CategoryFieldDao implements ICategoryFieldDao {

	@Autowired
	private EntityManager entitymanger;

	@Override
	public void createCategoryField(CategoryField u) {
		// TODO Auto-generated method stub
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(sdf.format(date));
		u.setCreated_at(sdf.format(date));
		entitymanger.persist(u);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CategoryField> getAllCategoryFields() {
		// TODO Auto-generated method stub
		return entitymanger.createQuery("FROM CategoryField").getResultList();
	}

	@Override
	public void updateCategoryField(CategoryField u) {
		// TODO Auto-generated method stub

		CategoryField cf = getCategoryFieldById(u.getField_id());
		cf.setLabel(u.getLabel());
		cf.setUnit(u.getUnit());
		cf.setDefault_value(u.getDefault_value());
		cf.setHelp_text(u.getHelp_text());
		cf.setRequired(u.getRequired());
		cf.setSort_order(u.getSort_order());
		cf.setStatus(u.getStatus());
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(sdf.format(date));
		// u.setCreated_at(sdf.format(date));
		u.setUpdated_at(sdf.format(date));
		entitymanger.flush();
	}

	@Override
	public CategoryField getCategoryFieldById(int CategoryFieldId) {
		// TODO Auto-generated method stub
		return entitymanger.find(CategoryField.class, CategoryFieldId);
	}

}
