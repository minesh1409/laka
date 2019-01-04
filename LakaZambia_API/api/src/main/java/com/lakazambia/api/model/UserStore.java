package com.lakazambia.api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="ea_user_store")
public class UserStore implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4419054023638039156L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="store_id")
	private int store_id;
	
	@Column(name="slug")
	private String slug;
	
	@Column(name="user_id")
	private Long user_id;
	
	@Column(name="store_name")
	private String store_name;
	
	@Column(name="company_name")
	private String company_name;
	
	@Column(name="company_no")
	private String company_no;
	
	@Column(name="vat")
	private String vat;
	
	@Column(name="status")
	private String status;
	
	@Column(name="created_at")
	private String created_at;

	@Column(name="updated_at")
	private String updated_at;
	public UserStore() {
		//super();
	}
	

	public UserStore(int store_id) {
		super();
		this.store_id = store_id;
	}
	


	

	public UserStore(int store_id, String slug, Long user_id, String store_name, String company_name, String company_no,
			String vat, String status, String created_at, String updated_at) {
		super();
		this.store_id = store_id;
		this.slug = slug;
		this.user_id = user_id;
		this.store_name = store_name;
		this.company_name = company_name;
		this.company_no = company_no;
		this.vat = vat;
		this.status = status;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}


	public int getStore_id() {
		return store_id;
	}

	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getStore_name() {
		return store_name;
	}

	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getCompany_no() {
		return company_no;
	}

	public void setCompany_no(String company_no) {
		this.company_no = company_no;
	}

	public String getVat() {
		return vat;
	}

	public void setVat(String vat) {
		this.vat = vat;
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
		result = prime * result + ((company_name == null) ? 0 : company_name.hashCode());
		result = prime * result + ((company_no == null) ? 0 : company_no.hashCode());
		result = prime * result + ((created_at == null) ? 0 : created_at.hashCode());
		result = prime * result + ((slug == null) ? 0 : slug.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + store_id;
		result = prime * result + ((store_name == null) ? 0 : store_name.hashCode());
		result = prime * result + ((updated_at == null) ? 0 : updated_at.hashCode());
		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
		result = prime * result + ((vat == null) ? 0 : vat.hashCode());
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
		UserStore other = (UserStore) obj;
		if (company_name == null) {
			if (other.company_name != null)
				return false;
		} else if (!company_name.equals(other.company_name))
			return false;
		if (company_no == null) {
			if (other.company_no != null)
				return false;
		} else if (!company_no.equals(other.company_no))
			return false;
		if (created_at == null) {
			if (other.created_at != null)
				return false;
		} else if (!created_at.equals(other.created_at))
			return false;
		if (slug == null) {
			if (other.slug != null)
				return false;
		} else if (!slug.equals(other.slug))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (store_id != other.store_id)
			return false;
		if (store_name == null) {
			if (other.store_name != null)
				return false;
		} else if (!store_name.equals(other.store_name))
			return false;
		if (updated_at == null) {
			if (other.updated_at != null)
				return false;
		} else if (!updated_at.equals(other.updated_at))
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		if (vat == null) {
			if (other.vat != null)
				return false;
		} else if (!vat.equals(other.vat))
			return false;
		return true;
	}


	

}
