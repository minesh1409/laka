package com.lakazambia.api.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name="ea_category_field_value")
public class CategoryFieldValue {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="value_id")
	private int value_id;
	
	@Column(name="field_id")
	private int field_id;
	
	@Column(name="listing_id")
	private int listing_id;
	
	@Column(name="value")
	private String value;
	
	@Column(name="created_at")
	private String created_at;
	
	@Column(name="updated_at")
	private String updated_at;

	
	/*@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "field_id",insertable=false,updatable=false)
	private CategoryField categoryField;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "listing_id",insertable=false,updatable=false)
	private Advertisement advertisement;*/

	public CategoryFieldValue() {
		//super();
	}
	
	

	public CategoryFieldValue(int value_id) {
		//super();
		this.value_id = value_id;
	}



	public CategoryFieldValue(int value_id, int field_id, int listing_id, String value, String created_at,
			String updated_at) {
		//super();
		this.value_id = value_id;
		this.field_id = field_id;
		this.listing_id = listing_id;
		this.value = value;
		this.created_at = created_at;
		this.updated_at = updated_at;
		
	}



	public int getValue_id() {
		return value_id;
	}



	public void setValue_id(int value_id) {
		this.value_id = value_id;
	}



	public int getField_id() {
		return field_id;
	}



	public void setField_id(int field_id) {
		this.field_id = field_id;
	}



	public int getListing_id() {
		return listing_id;
	}



	public void setListing_id(int listing_id) {
		this.listing_id = listing_id;
	}



	public String getValue() {
		return value;
	}



	public void setValue(String value) {
		this.value = value;
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
