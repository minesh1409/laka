package com.lakazambia.api.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lakazambia.api.dao.ISubSubCategory;
import com.lakazambia.api.model.SubSubCategory;

@Transactional
@Repository
public class SubSubCatDAo implements ISubSubCategory{

	@Autowired
	private EntityManager em;

	@Override
	public void createSubSubCategory(SubSubCategory u) {
		// TODO Auto-generated method stub
		em.persist(u);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SubSubCategory> getAllSubSubCategories() {
		// TODO Auto-generated method stub
		return em.createQuery("FROM SubSubCategory").getResultList();
	}

	@Override
	public void updateSubSubCategory(SubSubCategory u) {
		// TODO Auto-generated method stub
		SubSubCategory ssc=getSubSubCategoryById(u.getSub_subcat_id());
		ssc.setName(u.getName());
		ssc.setShort_name(u.getShort_name());
		ssc.setUpdated_at(u.getUpdated_at());
		em.flush();
	}

	@Override
	public SubSubCategory getSubSubCategoryById(int SubSubCategoryId) {
		// TODO Auto-generated method stub
		return em.find(SubSubCategory.class, SubSubCategoryId);
	}

	@Override
	public List<SubSubCategory> getSubSubCatByCatId(int SubCatid) {
		// TODO Auto-generated method stub
		List<SubSubCategory> result=null;
		System.out.println("Sub Cat Id :: " +SubCatid);
		String hql="FROM SubSubCategory as u where u.sub_cat_id = '"+ SubCatid +"'";
		System.out.println(hql);
		TypedQuery<SubSubCategory> qry = em.createQuery(hql,SubSubCategory.class);
		result= qry.getResultList();
		return result;
		/*String hql="FROM SubSubCategory as u where u.sub_cat_id = '"+ SubCatid +"'";
		return (List<SubSubCategory>) em.createQuery(hql, SubSubCategory.class);*/
	}

	
	
	
}
