package com.lakazambia.api.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ea_order")
public class Order implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1802484276327548321L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="order_id")
	private int order_id;
	
	@Column(name="listing_id",insertable=false,updatable=false)
	private int listing_id;
	
	@Column(name="user_id",insertable=false,updatable=false)
	private Long user_id;
	
	@Column(name="promo_code_id")
	private int promo_code_id;
	
	@Column(name="order_title")
	private String order_title;
	
	@Column(name="first_name")
	private String first_name;
	
	@Column(name="last_name")
	private String last_name;
	
	@Column(name="company_name")
	private String company_name;
	
	@Column(name="company_no")
	private String company_no;
	
	@Column(name="vat")
	private String vat;
	
	@Column(name="country_id",insertable=false,updatable=false)
	private int country_id;
	
	@Column(name="zone_id",insertable=false,updatable=false)
	private int zone_id;
	
	@Column(name="city")
	private String city;
	
	@Column(name="zip")
	private String zip;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="discount")
	private int discount;
	
	@Column(name="subtotal")
	private int subtotal;
	
	@Column(name="total")
	private int total;
	
	@Column(name="status")
	private String status;
	
	@Column(name="created_at")
	private String created_at;
	
	@Column(name="updated_at")
	private String updated_at;
	
	
	/*@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "listing_id")
	private Advertisement advertisement;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "country_id")
	private Country country;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "zone_id")
	private Zone zone;*/
	

	public Order() {
		//super();
	}

	public Order(int order_id) {
		super();
		this.order_id = order_id;
	}

	

	public Order(int order_id, int listing_id, Long user_id, int promo_code_id, String order_title, String first_name,
			String last_name, String company_name, String company_no, String vat, int country_id, int zone_id,
			String city, String zip, String phone, int discount, int subtotal, int total, String status,
			String created_at, String updated_at) {
		super();
		this.order_id = order_id;
		this.listing_id = listing_id;
		this.user_id = user_id;
		this.promo_code_id = promo_code_id;
		this.order_title = order_title;
		this.first_name = first_name;
		this.last_name = last_name;
		this.company_name = company_name;
		this.company_no = company_no;
		this.vat = vat;
		this.country_id = country_id;
		this.zone_id = zone_id;
		this.city = city;
		this.zip = zip;
		this.phone = phone;
		this.discount = discount;
		this.subtotal = subtotal;
		this.total = total;
		this.status = status;
		this.created_at = created_at;
		this.updated_at = updated_at;
		
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getListing_id() {
		return listing_id;
	}

	public void setListing_id(int listing_id) {
		this.listing_id = listing_id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public int getPromo_code_id() {
		return promo_code_id;
	}

	public void setPromo_code_id(int promo_code_id) {
		this.promo_code_id = promo_code_id;
	}

	public String getOrder_title() {
		return order_title;
	}

	public void setOrder_title(String order_title) {
		this.order_title = order_title;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
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
	

	
	

	
	

}
