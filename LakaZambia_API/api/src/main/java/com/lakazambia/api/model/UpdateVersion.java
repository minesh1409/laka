package com.lakazambia.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="remote_update")
public class UpdateVersion {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="version_code")
	private String version_code;
	
	@Column(name="version_name")
	private String version_name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVersion_code() {
		return version_code;
	}

	public void setVersion_code(String version_code) {
		this.version_code = version_code;
	}

	public String getVersion_name() {
		return version_name;
	}

	public void setVersion_name(String version_name) {
		this.version_name = version_name;
	}
	
	

}
