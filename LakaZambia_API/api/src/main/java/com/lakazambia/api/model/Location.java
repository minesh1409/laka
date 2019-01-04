package com.lakazambia.api.model;

import java.math.BigDecimal;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name="ea_location")
public class Location {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int location_id;
	
	@Column(name="country_id",insertable=false,updatable=false)
	private int country_id;
	
	@Column(name="zone_id",insertable=false,updatable=false)
	private int zone_id;
	
	@Column(name="city")
	private String city;
	
	@Column(name="zip")
	private String zip;
	
	@Column(name="latitude")
	private BigDecimal latitude;
	
	@Column(name="longitude")
	private BigDecimal longitude;
	
	@Column(name="retries")
	private int retries;
	
	@Column(name="status")
	private String status;
	
	@Column(name="created_at")
	private String created_at;
	
	@Column(name="updated_at")
	private String  updated_at;
	
	
	/*@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "country_id")
	private Country country;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="zone_id")
	private Zone zone;*/

	public Location() {
		super();
	}

	public Location(int location_id) {
		super();
		this.location_id = location_id;
	}


	

	public Location(int location_id, int country_id, int zone_id, String city, String zip, BigDecimal latitude,
			BigDecimal longitude, int retries, String status, String created_at, String updated_at) {
		super();
		this.location_id = location_id;
		this.country_id = country_id;
		this.zone_id = zone_id;
		this.city = city;
		this.zip = zip;
		this.latitude = latitude;
		this.longitude = longitude;
		this.retries = retries;
		this.status = status;
		this.created_at = created_at;
		this.updated_at = updated_at;
		
	}

	public int getLocation_id() {
		return location_id;
	}

	public void setLocation_id(int location_id) {
		this.location_id = location_id;
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

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public int getRetries() {
		return retries;
	}

	public void setRetries(int retries) {
		this.retries = retries;
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
