package com.lakazambia.api.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="ea_invoice")
public class Invoice implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1204572466428852942L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="invoice_id")
	private int invoice_id;
	
	@Column(name="order_id",updatable=false,insertable=false)
	private int order_id;
	
	@Column(name="created_at")
	private String created_at;
	
	@Column(name="updated_at")
	private String updated_at;
	
/*	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id")
	private Order order;*/

	public Invoice() {
		super();
	}


	public Invoice(int invoice_id) {
		super();
		this.invoice_id = invoice_id;
	}


	public Invoice(int invoice_id, int order_id, String created_at, String updated_at) {
		super();
		this.invoice_id = invoice_id;
		this.order_id = order_id;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}


	public int getInvoice_id() {
		return invoice_id;
	}


	public void setInvoice_id(int invoice_id) {
		this.invoice_id = invoice_id;
	}


	public int getOrder_id() {
		return order_id;
	}


	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}


	public String getCreated_at() {
		return created_at;
	}


	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}


	public String getUpdated_at() {
		return updated_at;
	}


	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}


	
}
