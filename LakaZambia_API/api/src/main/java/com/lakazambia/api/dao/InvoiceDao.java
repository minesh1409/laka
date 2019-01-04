package com.lakazambia.api.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lakazambia.api.model.Invoice;

@Transactional
@Repository
public class InvoiceDao implements IInvoiceDao{
	
	@Autowired
	private EntityManager entitymanager;

	@Override
	public void createInvoice(Invoice u) {
		// TODO Auto-generated method stub
		 DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			System.out.println(sdf.format(date));
			u.setCreated_at(sdf.format(date));
		entitymanager.persist(u);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Invoice> getAllInvoices() {
		// TODO Auto-generated method stub
		return entitymanager.createQuery("FROM Invoice").getResultList();
	}

	@Override
	public void updateInvoice(Invoice u) {
		// TODO Auto-generated method stub
		Invoice invoice=getInvoiceById(u.getInvoice_id());
		invoice.setUpdated_at(u.getUpdated_at());
		entitymanager.flush();
	}

	@Override
	public Invoice getInvoiceById(int InvoiceId) {
		// TODO Auto-generated method stub
		return entitymanager.find(Invoice.class, InvoiceId);
	}

}
