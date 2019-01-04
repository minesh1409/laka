package com.lakazambia.api.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ea_country")
public class Country {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "country_id")
	private int country_id;
	
	@Column(name="code")
	private String code;
	
	@Column(name="name")
	private String name;
	
	@Column(name="status")
	private String status;
	
	@Column(name="created_at")
	private Date created_at;
	
	@Column(name="updated_at")
	private Date updated_at;

	public Country() {
		
	}

	public Country(int country_id) {
		
		this.country_id = country_id;
	}

	public Country(int country_id, String code, String name, String status, Date created_at, Date updated_at) {
	
		this.country_id = country_id;
		this.code = code;
		this.name = name;
		this.status = status;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	public int getCountry_id() {
		return country_id;
	}

	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	
	 
	
	
	

}
