package com.lakazambia.api.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="ea_currency")
public class Currency implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3696645971348792894L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="currency_id")
	private int currency_id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="code")
	private String code;
	
	@Column(name="symbol")
	private String symbol;
	
	@Column(name="status")
	private String status;
	
	@Column(name="created_at")
	private String created_at;
	
	@Column(name="updated_at")
	private String updated_at;

	
	
	public Currency() {
		//super();
	}



	public Currency(int currency_id) {
		//super();
		this.currency_id = currency_id;
	}



	public Currency(int currency_id, String name, String code, String symbol, String status, String created_at,
			String updated_at) {
		super();
		this.currency_id = currency_id;
		this.name = name;
		this.code = code;
		this.symbol = symbol;
		this.status = status;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}



	public int getCurrency_id() {
		return currency_id;
	}



	public void setCurrency_id(int currency_id) {
		this.currency_id = currency_id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}



	public String getSymbol() {
		return symbol;
	}



	public void setSymbol(String symbol) {
		this.symbol = symbol;
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
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((created_at == null) ? 0 : created_at.hashCode());
		result = prime * result + currency_id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
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
		Currency other = (Currency) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (created_at == null) {
			if (other.created_at != null)
				return false;
		} else if (!created_at.equals(other.created_at))
			return false;
		if (currency_id != other.currency_id)
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
		if (symbol == null) {
			if (other.symbol != null)
				return false;
		} else if (!symbol.equals(other.symbol))
			return false;
		if (updated_at == null) {
			if (other.updated_at != null)
				return false;
		} else if (!updated_at.equals(other.updated_at))
			return false;
		return true;
	}
	
	
	
	
	
}
