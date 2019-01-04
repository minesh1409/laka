package com.lakazambia.api.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="ea_order_transaction")
public class OrderTransaction {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="transaction_id")
	private int transaction_id;
	
	@Column(name="order_id",insertable=false,updatable=false)
	private int order_id;
	
	@Column(name="gateway")
	private String gateway;
	
	@Column(name="type")
	private String type;
	
	@Column(name="transaction_reference")
	private String transaction_reference;
	
	@Column(name="gateway_response")
	private String gateway_response;
	
	@Column(name="created_at")
	private String created_at;
	
	@Column(name="updated_at")
	private String updated_at;
	
	
/*	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id")
	private Order order;*/


	public OrderTransaction() {
		super();
	}


	public OrderTransaction(int transaction_id) {
		super();
		this.transaction_id = transaction_id;
	}


	public OrderTransaction(int transaction_id, int order_id, String gateway, String type, String transaction_reference,
			String gateway_response, String created_at, String updated_at) {
		super();
		this.transaction_id = transaction_id;
		this.order_id = order_id;
		this.gateway = gateway;
		this.type = type;
		this.transaction_reference = transaction_reference;
		this.gateway_response = gateway_response;
		this.created_at = created_at;
		this.updated_at = updated_at;
		
	}


	public int getTransaction_id() {
		return transaction_id;
	}


	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}


	public int getOrder_id() {
		return order_id;
	}


	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}


	public String getGateway() {
		return gateway;
	}


	public void setGateway(String gateway) {
		this.gateway = gateway;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getTransaction_reference() {
		return transaction_reference;
	}


	public void setTransaction_reference(String transaction_reference) {
		this.transaction_reference = transaction_reference;
	}


	public String getGateway_response() {
		return gateway_response;
	}


	public void setGateway_response(String gateway_response) {
		this.gateway_response = gateway_response;
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
