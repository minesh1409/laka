package com.lakazambia.api.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lakazambia.api.model.Tax;

@Transactional
@Repository
public class TaxDao implements ITaxDao{
	
	@Autowired
	private EntityManager entitymanger;

	@Override
	public void createTax(Tax u) {
		// TODO Auto-generated method stub
		 DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			System.out.println(sdf.format(date));
			u.setCreated_at(sdf.format(date));
		entitymanger.persist(u);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tax> getAllTaxes() {
		// TODO Auto-generated method stub
		return entitymanger.createQuery("FROM Tax").getResultList();
	}

	@Override
	public void updateTax(Tax u) {
		// TODO Auto-generated method stub
		Tax tax=getTaxById(u.getTax_id());
		tax.setName(u.getName());
		tax.setPercent(u.getPercent());
		tax.setIs_global(u.getIs_global());
		tax.setStatus(u.getStatus());
		tax.setUpdated_at(u.getUpdated_at());
		 DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			System.out.println(sdf.format(date));
			//u.setCreated_at(sdf.format(date));
			u.setUpdated_at(sdf.format(date));
		entitymanger.flush();
		
	}

	@Override
	public Tax getTaxById(int TaxId) {
		// TODO Auto-generated method stub
		return entitymanger.find(Tax.class, TaxId);
	}

	
	
}
