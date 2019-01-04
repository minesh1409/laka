package com.lakazambia.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ea_listing_stat")
public class ListingState {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="listing_id")
	private int listing_id;
	
	@Column(name="total_views")
	private int total_views;
	
	@Column(name="facebook_shares")
	private int facebook_shares;
	
	@Column(name="twitter_shares")
	private int twitter_shares;
	
	@Column(name="mail_shares")
	private int mail_shares;
	
	@Column(name="favorite")
	private int favorite;
	
	@Column(name="show_phone")
	private int show_phone;
	
	@Column(name="show_mail")
	private int show_mail;
	
	@Column(name="created_at")
	private String created_at;
	
	@Column(name="updated_at")
	private String updated_at;
	
	

	public ListingState() {
		//super();
	}



	public ListingState(int listing_id) {
		//super();
		this.listing_id = listing_id;
	}



	public ListingState(int listing_id, int total_views, int facebook_shares, int twitter_shares, int mail_shares,
			int favorite, int show_phone, int show_mail, String created_at, String updated_at) {
		//super();
		this.listing_id = listing_id;
		this.total_views = total_views;
		this.facebook_shares = facebook_shares;
		this.twitter_shares = twitter_shares;
		this.mail_shares = mail_shares;
		this.favorite = favorite;
		this.show_phone = show_phone;
		this.show_mail = show_mail;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}



	public int getListing_id() {
		return listing_id;
	}



	public void setListing_id(int listing_id) {
		this.listing_id = listing_id;
	}



	public int getTotal_views() {
		return total_views;
	}



	public void setTotal_views(int total_views) {
		this.total_views = total_views;
	}



	public int getFacebook_shares() {
		return facebook_shares;
	}



	public void setFacebook_shares(int facebook_shares) {
		this.facebook_shares = facebook_shares;
	}



	public int getTwitter_shares() {
		return twitter_shares;
	}



	public void setTwitter_shares(int twitter_shares) {
		this.twitter_shares = twitter_shares;
	}



	public int getMail_shares() {
		return mail_shares;
	}



	public void setMail_shares(int mail_shares) {
		this.mail_shares = mail_shares;
	}



	public int getFavorite() {
		return favorite;
	}



	public void setFavorite(int favorite) {
		this.favorite = favorite;
	}



	public int getShow_phone() {
		return show_phone;
	}



	public void setShow_phone(int show_phone) {
		this.show_phone = show_phone;
	}



	public int getShow_mail() {
		return show_mail;
	}



	public void setShow_mail(int show_mail) {
		this.show_mail = show_mail;
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
