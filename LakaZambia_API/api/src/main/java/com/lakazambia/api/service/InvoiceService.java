package com.lakazambia.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lakazambia.api.dao.IInvoiceDao;
import com.lakazambia.api.model.Invoice;

@Service
public class InvoiceService implements IInvoiceService{
	
	@Autowired
	private IInvoiceDao invoiceDao;

	@Override
	public boolean createInvoice(Invoice c) {
		// TODO Auto-generated method stub
		invoiceDao.createInvoice(c);
		return true;
	}

	@Override
	public Invoice getInvoiceById(int id) {
		// TODO Auto-generated method stub
		return invoiceDao.getInvoiceById(id);
	}

	@Override
	public List<Invoice> getAllInvoices() {
		// TODO Auto-generated method stub
		return invoiceDao.getAllInvoices();
	}

	@Override
	public void updateInvoice(Invoice c) {
		// TODO Auto-generated method stub
		invoiceDao.updateInvoice(c);
	}

}
