package com.lakazambia.api.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;



@Entity
@Table(name="ea_reviews")
public class Review implements Serializable{
	
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="review_id")
	private int review_id;
	
	@Column(name="user_id",insertable=false,updatable=false)
	private Long user_id;
	
	@Column(name="listing_id",insertable=false,updatable=false)
	private int listing_id;
	
	@Column(name="review")
	private String review;
	
	
	@Column(name="created_at")
	private String created_at;
	
	@Column(name="updated_at")
	private String updated_at;
	
	
/*	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "listing_id")
	private Advertisement advertisement;*/
	

	public Review() {
		super();
	}

	public Review(int review_id) {
		super();
		this.review_id = review_id;
	}

	

	public Review(int review_id, Long user_id, int listing_id, String review, String created_at, String updated_at) {
		super();
		this.review_id = review_id;
		this.user_id = user_id;
		this.listing_id = listing_id;
		this.review = review;
		this.created_at = created_at;
		this.updated_at = updated_at;
		
	}

	public int getReview_id() {
		return review_id;
	}

	public void setReview_id(int review_id) {
		this.review_id = review_id;
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

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
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
