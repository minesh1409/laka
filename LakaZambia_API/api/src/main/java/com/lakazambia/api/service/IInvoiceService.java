package com.lakazambia.api.service;

import java.util.List;

import com.lakazambia.api.model.Invoice;

public interface IInvoiceService {
	
	boolean createInvoice(Invoice c);

	Invoice getInvoiceById(int id);

	List<Invoice> getAllInvoices();

	void updateInvoice(Invoice c);

}
