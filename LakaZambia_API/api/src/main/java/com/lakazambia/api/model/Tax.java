package com.lakazambia.api.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="ea_tax")
public class Tax implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -210804201132860869L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="tax_id")
	private int tax_id;
	
	@Column(name="country_id")
	private int country_id;
	
	@Column(name="zone_id")
	private int zone_id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="percent")
	private BigDecimal percent;
	
	@Column(name="is_global")
	private String is_global;
	
	@Column(name="Status")
	private String status;
	
	@Column(name="created_at")
	private String created_at;
	
	@Column(name="updated_at")
	private String updated_at;
	
	

	public Tax() {
		super();
	}



	public Tax(int tax_id) {
		super();
		this.tax_id = tax_id;
	}



	public Tax(int tax_id, int country_id, int zone_id, String name, BigDecimal percent, String is_global,
			String status, String created_at, String updated_at) {
		super();
		this.tax_id = tax_id;
		this.country_id = country_id;
		this.zone_id = zone_id;
		this.name = name;
		this.percent = percent;
		this.is_global = is_global;
		this.status = status;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}



	public int getTax_id() {
		return tax_id;
	}



	public void setTax_id(int tax_id) {
		this.tax_id = tax_id;
	}



	public int getCountry_id() {
		return country_id;
	}



	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}



	public int getZone_id() {
		return zone_id;
	}



	public void setZone_id(int zone_id) {
		this.zone_id = zone_id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public BigDecimal getPercent() {
		return percent;
	}



	public void setPercent(BigDecimal percent) {
		this.percent = percent;
	}



	public String getIs_global() {
		return is_global;
	}



	public void setIs_global(String is_global) {
		this.is_global = is_global;
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
		result = prime * result + country_id;
		result = prime * result + ((created_at == null) ? 0 : created_at.hashCode());
		result = prime * result + ((is_global == null) ? 0 : is_global.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((percent == null) ? 0 : percent.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + tax_id;
		result = prime * result + ((updated_at == null) ? 0 : updated_at.hashCode());
		result = prime * result + zone_id;
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
		Tax other = (Tax) obj;
		if (country_id != other.country_id)
			return false;
		if (created_at == null) {
			if (other.created_at != null)
				return false;
		} else if (!created_at.equals(other.created_at))
			return false;
		if (is_global == null) {
			if (other.is_global != null)
				return false;
		} else if (!is_global.equals(other.is_global))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (percent == null) {
			if (other.percent != null)
				return false;
		} else if (!percent.equals(other.percent))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (tax_id != other.tax_id)
			return false;
		if (updated_at == null) {
			if (other.updated_at != null)
				return false;
		} else if (!updated_at.equals(other.updated_at))
			return false;
		if (zone_id != other.zone_id)
			return false;
		return true;
	}
	
	
	

}
