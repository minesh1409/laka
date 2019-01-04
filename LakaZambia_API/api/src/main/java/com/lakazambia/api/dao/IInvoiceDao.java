package com.lakazambia.api.dao;

import java.util.List;

import com.lakazambia.api.model.Invoice;

public interface IInvoiceDao {
	
	void createInvoice(Invoice u);

	List<Invoice> getAllInvoices();

	void updateInvoice(Invoice u);

	Invoice getInvoiceById(int InvoiceId);

}
