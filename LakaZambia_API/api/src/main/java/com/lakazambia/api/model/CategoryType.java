package com.lakazambia.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="ea_category_field_type")
public class CategoryType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="type_id")
	private int type_id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="class_name")
	private String class_name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="status")
	private String status;
	
	@Column(name="created_at")
	private String created_at;
	
	@Column(name="updated_at")
	private String updated_at;

	
	public CategoryType() {
	//	super();
	}


	public CategoryType(int type_id) {
		//super();
		this.type_id = type_id;
	}


	public CategoryType(int type_id, String name, String class_name, String description, String status,
			String created_at, String updated_at) {
		//super();
		this.type_id = type_id;
		this.name = name;
		this.class_name = class_name;
		this.description = description;
		this.status = status;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}


	public int getType_id() {
		return type_id;
	}


	public void setType_id(int type_id) {
		this.type_id = type_id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getClass_name() {
		return class_name;
	}


	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((class_name == null) ? 0 : class_name.hashCode());
		result = prime * result + ((created_at == null) ? 0 : created_at.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + type_id;
		result = prime * result + ((updated_at == null) ? 0 : updated_at.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoryType other = (CategoryType) obj;
		if (class_name == null) {
			if (other.class_name != null)
				return false;
		} else if (!class_name.equals(other.class_name))
			return false;
		if (created_at == null) {
			if (other.created_at != null)
				return false;
		} else if (!created_at.equals(other.created_at))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (type_id != other.type_id)
			return false;
		if (updated_at == null) {
			if (other.updated_at != null)
				return false;
		} else if (!updated_at.equals(other.updated_at))
			return false;
		return true;
	}
	
	
}
