package com.lakazambia.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ea_rate_sheet")
public class ForeignExchange {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="c_id")
	private int c_id;
	
	
	@Column(name="currency_name")
	private String currency_name;
	
	
	@Column(name="zambian_currency_value")
	private String zambian_currency_value;

	@Column(name="offer_value")
	private double offer_value;

	
	public ForeignExchange() {
		super();
	}



	public ForeignExchange(int c_id) {
		super();
		this.c_id = c_id;
	}



	


	public ForeignExchange(int c_id, String currency_name, String zambian_currency_value, double offer_value) {
		super();
		this.c_id = c_id;
		this.currency_name = currency_name;
		this.zambian_currency_value = zambian_currency_value;
		this.offer_value = offer_value;
	}



	public int getC_id() {
		return c_id;
	}



	public void setC_id(int c_id) {
		this.c_id = c_id;
	}



	public String getCurrency_name() {
		return currency_name;
	}



	public void setCurrency_name(String currency_name) {
		this.currency_name = currency_name;
	}



	public String getZambian_currency_value() {
		return zambian_currency_value;
	}



	public void setZambian_currency_value(String zambian_currency_value) {
		this.zambian_currency_value = zambian_currency_value;
	}

	

	public double getOffer_value() {
		return offer_value;
	}



	public void setOffer_value(double offer_value) {
		this.offer_value = offer_value;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + c_id;
		result = prime * result + ((currency_name == null) ? 0 : currency_name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(offer_value);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((zambian_currency_value == null) ? 0 : zambian_currency_value.hashCode());
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
		ForeignExchange other = (ForeignExchange) obj;
		if (c_id != other.c_id)
			return false;
		if (currency_name == null) {
			if (other.currency_name != null)
				return false;
		} else if (!currency_name.equals(other.currency_name))
			return false;
		if (Double.doubleToLongBits(offer_value) != Double.doubleToLongBits(other.offer_value))
			return false;
		if (zambian_currency_value == null) {
			if (other.zambian_currency_value != null)
				return false;
		} else if (!zambian_currency_value.equals(other.zambian_currency_value))
			return false;
		return true;
	}



	
	
	
	
	
	

}
