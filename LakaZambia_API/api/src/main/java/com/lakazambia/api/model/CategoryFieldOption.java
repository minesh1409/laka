package com.lakazambia.api.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;



@Entity
@Table(name="ea_category_field_option")
public class CategoryFieldOption {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="option_id")
	private int option_id;
	
	@Column(name="field_id",insertable=false,updatable=false)
	private int field_id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="value")
	private String value;
	
	@Column(name="created_at")
	private String created_at;

	@Column(name="updated_at")
	private String updated_at;
	
	/*@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "field_id")
	private CategoryField categoryField;*/
	
	

	public CategoryFieldOption() {
		super();
	}



	public CategoryFieldOption(int option_id) {
		super();
		this.option_id = option_id;
	}



	public CategoryFieldOption(int option_id, int field_id, String name, String value, String created_at,
			String updated_at) {
		super();
		this.option_id = option_id;
		this.field_id = field_id;
		this.name = name;
		this.value = value;
		this.created_at = created_at;
		this.updated_at = updated_at;
		
	}



	public int getOption_id() {
		return option_id;
	}



	public void setOption_id(int option_id) {
		this.option_id = option_id;
	}



	public int getField_id() {
		return field_id;
	}



	public void setField_id(int field_id) {
		this.field_id = field_id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
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



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((created_at == null) ? 0 : created_at.hashCode());
		result = prime * result + field_id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + option_id;
		result = prime * result + ((updated_at == null) ? 0 : updated_at.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		CategoryFieldOption other = (CategoryFieldOption) obj;
		if (created_at == null) {
			if (other.created_at != null)
				return false;
		} else if (!created_at.equals(other.created_at))
			return false;
		if (field_id != other.field_id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (option_id != other.option_id)
			return false;
		if (updated_at == null) {
			if (other.updated_at != null)
				return false;
		} else if (!updated_at.equals(other.updated_at))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}



	



	
	
	
	
}
