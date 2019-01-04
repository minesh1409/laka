package com.lakazambia.api.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name="ea_sub_subcategory")
public class SubSubCategory implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1177204027416853117L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="sub_subcat_id")
	private int sub_subcat_id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="short_name")
	private String short_name;
	
	@Column(name="status")
	private String status;
	
	@Column(name="created_at")
	private String created_at;
	
	@Column(name="updated_at")
	private String updated_at;
	

	@Column(name="sub_cat_id")
	private int sub_cat_id;
	
	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sub_cat_id", nullable = false)
	private SubSubCategory subsubCat;*/

	public SubSubCategory() {
		super();
	}

	public SubSubCategory(int sub_subcat_id) {
		super();
		this.sub_subcat_id = sub_subcat_id;
	}

	

	

	public SubSubCategory(int sub_subcat_id, String name, String short_name, String status, String created_at,
			String updated_at, int sub_cat_id) {
		super();
		this.sub_subcat_id = sub_subcat_id;
		this.name = name;
		this.short_name = short_name;
		this.status = status;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.sub_cat_id = sub_cat_id;
	}

	public int getSub_subcat_id() {
		return sub_subcat_id;
	}

	public void setSub_subcat_id(int sub_subcat_id) {
		this.sub_subcat_id = sub_subcat_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShort_name() {
		return short_name;
	}

	public void setShort_name(String short_name) {
		this.short_name = short_name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public int getSub_cat_id() {
		return sub_cat_id;
	}

	public void setSub_cat_id(int sub_cat_id) {
		this.sub_cat_id = sub_cat_id;
	}


	
	
	
}
