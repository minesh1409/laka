package com.lakazambia.api.model;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ea_zone")
public class Zone {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "zone_id")
	private int zone_id;
	
	@Column(name="country_id",insertable=false,updatable=false)
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
	
	
	
	/*@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "country_id")
	private Country country;*/

	public Zone() {
		//super();
	}

	public Zone(int zone_id) {
		//super();
		this.zone_id = zone_id;
	}

	public Zone(int zone_id, int country_id, String code, String name, String status, Date created_at,
			Date updated_at) {
		super();
		this.zone_id = zone_id;
		this.country_id = country_id;
		this.code = code;
		this.name = name;
		this.status = status;
		this.created_at = created_at;
		this.updated_at = updated_at;
	
	}



	

	public int getZone_id() {
		return zone_id;
	}

	public void setZone_id(int zone_id) {
		this.zone_id = zone_id;
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
