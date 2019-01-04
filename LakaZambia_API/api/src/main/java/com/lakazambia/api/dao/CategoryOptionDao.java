package com.lakazambia.api.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lakazambia.api.model.CategoryFieldOption;

@Transactional
@Repository
public class CategoryOptionDao implements ICategoryOptionDao {

	@Autowired
	private EntityManager entitymanager;

	@Override
	public void createCategoryFieldOption(CategoryFieldOption u) {
		// TODO Auto-generated method stub
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(sdf.format(date));
		u.setCreated_at(sdf.format(date));
		entitymanager.persist(u);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CategoryFieldOption> getAllCategoryFieldOptions() {
		// TODO Auto-generated method stub
		return entitymanager.createQuery("FROM CategoryFieldOption").getResultList();
	}

	@Override
	public void updateCategoryFieldOption(CategoryFieldOption u) {
		// TODO Auto-generated method stub
		CategoryFieldOption cfo = getCategoryFieldOptionById(u.getOption_id());
		cfo.setName(u.getName());
		cfo.setValue(u.getValue());
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(sdf.format(date));
		// u.setCreated_at(sdf.format(date));
		u.setUpdated_at(sdf.format(date));

		entitymanager.flush();
	}

	@Override
	public CategoryFieldOption getCategoryFieldOptionById(int CategoryFieldOptionId) {
		// TODO Auto-generated method stub
		return entitymanager.find(CategoryFieldOption.class, CategoryFieldOptionId);
	}

}
