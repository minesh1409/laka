package com.lakazambia.api.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name="ea_listing_favorite")
public class Favourites {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="favorite_id")
	private int favourite_id;
	
	@Column(name="user_id")
	private Long user_id;
	
	@Column(name="listing_id")
	private int listing_id;
	
	@Column(name="created_at")
	private String created_at;
	
	@Column(name="updated_at")
	private String updated_at;
	
	/*@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id",insertable=false,updatable=false)
	private User user;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "listing_id",insertable=false,updatable=false)
	private Advertisement advertisement;*/	
	
	

	public Favourites() {
		//super();
	}



	public Favourites(int favourite_id) {
		//super();
		this.favourite_id = favourite_id;
	}



	public Favourites(int favourite_id, Long user_id, int listing_id, String created_at, String updated_at) {
		//super();
		this.favourite_id = favourite_id;
		this.user_id = user_id;
		this.listing_id = listing_id;
		this.created_at = created_at;
		this.updated_at = updated_at;
	
	}



	public int getFavourite_id() {
		return favourite_id;
	}



	public void setFavourite_id(int favourite_id) {
		this.favourite_id = favourite_id;
	}



	public Long getUser_id() {
		return user_id;
	}



	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}



	public int getListing_id() {
		return listing_id;
	}



	public void setListing_id(int listing_id) {
		this.listing_id = listing_id;
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
