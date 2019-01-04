package com.lakazambia.api.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ea_listing_image")
public class ImageListing {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="image_id")
	private int image_id;
	
	@Column(name="listing_id")
	private int listing_id;
	
	@Column(name="image_path")
	private String image_path;
	
	@Column(name="sort_order")
	private int sort_order;
	
	@Column(name="created_at")
	private String created_at;
	
	@Column(name="updated_at")
	private String updated_at;
	
	/*@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "listing_id",insertable=false,updatable=false)
	private Advertisement advertisement;*/

	
	
	public ImageListing() {
		//super();
	}



	public ImageListing(int image_id) {
		//super();
		this.image_id = image_id;
	}



	public ImageListing(int image_id, int listing_id, String image_path, int sort_order, String created_at,
			String updated_at) {
		//super();
		this.image_id = image_id;
		this.listing_id = listing_id;
		this.image_path = image_path;
		this.sort_order = sort_order;
		this.created_at = created_at;
		this.updated_at = updated_at;
	
	}



	public int getImage_id() {
		return image_id;
	}



	public void setImage_id(int image_id) {
		this.image_id = image_id;
	}



	public int getListing_id() {
		return listing_id;
	}



	public void setListing_id(int listing_id) {
		this.listing_id = listing_id;
	}



	public String getImage_path() {
		return image_path;
	}



	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}



	public int getSort_order() {
		return sort_order;
	}



	public void setSort_order(int sort_order) {
		this.sort_order = sort_order;
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
