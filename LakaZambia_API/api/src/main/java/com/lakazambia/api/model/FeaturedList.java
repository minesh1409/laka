package com.lakazambia.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="ea_featured")
public class FeaturedList {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="featured_id")
	private int featured_id;
	
	@Column(name="featured_name")
	private String featured_name;
	
	@Column(name="created_at")
	private String created_at;
	
	@Column(name="updated_at")
	private String updated_at;

	
	public FeaturedList() {
		super();
	}


	public FeaturedList(int featured_id) {
		super();
		this.featured_id = featured_id;
	}


	public FeaturedList(int featured_id, String featured_name, String created_at, String updated_at) {
		super();
		this.featured_id = featured_id;
		this.featured_name = featured_name;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}


	public int getFeatured_id() {
		return featured_id;
	}


	public void setFeatured_id(int featured_id) {
		this.featured_id = featured_id;
	}


	public String getFeatured_name() {
		return featured_name;
	}


	public void setFeatured_name(String featured_name) {
		this.featured_name = featured_name;
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
		result = prime * result + featured_id;
		result = prime * result + ((featured_name == null) ? 0 : featured_name.hashCode());
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
		FeaturedList other = (FeaturedList) obj;
		if (created_at == null) {
			if (other.created_at != null)
				return false;
		} else if (!created_at.equals(other.created_at))
			return false;
		if (featured_id != other.featured_id)
			return false;
		if (featured_name == null) {
			if (other.featured_name != null)
				return false;
		} else if (!featured_name.equals(other.featured_name))
			return false;
		if (updated_at == null) {
			if (other.updated_at != null)
				return false;
		} else if (!updated_at.equals(other.updated_at))
			return false;
		return true;
	}
	
	
	
	
	
	
}
