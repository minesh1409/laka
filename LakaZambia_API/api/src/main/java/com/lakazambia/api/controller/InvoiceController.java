package com.lakazambia.api.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


import com.lakazambia.api.model.Invoice;
import com.lakazambia.api.service.IInvoiceService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@Api
public class InvoiceController {
	
	
	
	@Autowired
	private IInvoiceService invoiceService;
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(InvoiceController.class);
	
	
	@ApiOperation(value="Get All Invoices")
	@GetMapping("/invoices")
	public ResponseEntity<List<Invoice>> getAllInvoices(HttpServletRequest request) {
		
		List<Invoice> list = invoiceService.getAllInvoices();
		LOGGER.info("Get All Invoices");
		return new ResponseEntity<List<Invoice>>(list, HttpStatus.OK);
	}

	@ApiOperation(value="Post Invoice")
	@PostMapping("/invoice")
	public ResponseEntity<?> addInvoice(@RequestBody Invoice invoice, UriComponentsBuilder builder) {
		boolean flag = invoiceService.createInvoice(invoice);
		if (flag == false) {
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
		}
		LOGGER.info("Post Invoice");
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/invoice/{id}").buildAndExpand(invoice.getInvoice_id()).toUri());
		return new ResponseEntity<String>("Success", HttpStatus.CREATED);
	}

	@ApiOperation(value="Get Invoice By Id")
	@GetMapping("invoice/{id}")
	public ResponseEntity<Invoice> getInvoiceById(@PathVariable("id") int id) {
		Invoice in=invoiceService.getInvoiceById(id);
	
		LOGGER.info("Get Invoice By Id");
		return new ResponseEntity<Invoice>(in, HttpStatus.OK);
	}
	@ApiOperation(value="Update Invoice data")
	@PutMapping("updateInvoice")
	public ResponseEntity<Invoice> updateInvoice(@RequestBody Invoice invoice) {
		invoiceService.updateInvoice(invoice);
		LOGGER.info("Update Invoice data");
		return new ResponseEntity<Invoice>(invoice, HttpStatus.OK);
	}



}
