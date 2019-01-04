package com.lakazambia.api.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

import com.lakazambia.api.connection.RethinkDBConnectionFactory;
import com.lakazambia.api.model.Category;

import com.rethinkdb.RethinkDB;

@Transactional
@Repository
@PropertySource("classpath:db.properties")
public class CategoryDao implements ICategoryDao {
	
	
	
	private static final RethinkDB r = RethinkDB.r;
	@Autowired
	private RethinkDBConnectionFactory connectionFactory;
	
	
	@Value("${rethink.db}")
	public String db;

	@Value("${rethink.schema1}")
	public String tab;

	@Autowired
	private EntityManager entitymanager;

	@Override
	public void createCategory(Category c) {
		// TODO Auto-generated method stub
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(sdf.format(date));
		c.setCreated_at(sdf.format(date));
		entitymanager.persist(c);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return entitymanager.createQuery("FROM Category").getResultList();
	}

	@Override
	public void updateCategory(Category c) {
		// TODO Auto-generated method stub
		Category cat = getCategoryById(c.getCategory_id());
		cat.setName(c.getName());
		cat.setSlug(c.getSlug());
		cat.setDescription(c.getDescription());
		cat.setSort_order(c.getSort_order());
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(sdf.format(date));
		// u.setCreated_at(sdf.format(date));
		cat.setUpdated_at(sdf.format(date));
		entitymanager.flush();
	}

	@Override
	public Category getCategoryById(int categoryId) {
		// TODO Auto-generated method stub
		return entitymanager.find(Category.class, categoryId);
	}
	
	//FOR RETHINK

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		List<Category> cate =r.db(db).table(tab)
	    		   //.orderBy().optArg("index", r.desc("time"))
	                .limit(50)
	               .orderBy("time")
	    		   .run(connectionFactory.createConnection());
		 return cate;
	}

}
