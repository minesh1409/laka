package com.lakazambia.api.model;

import java.io.Serializable;



import javax.persistence.Column;

import javax.persistence.Entity;

import javax.persistence.Id;

import javax.persistence.Table;


@Entity
@Table(name="ea_advertisement")
public class Advertisement implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4669524039410988441L;

	@Id
	@Column(name="listing_id")
	private int listing_id;
	
	@Column(name="package_id")
	private int package_id;
	
	@Column(name="user_id")
	private Long user_id;
	
	@Column(name="location_id")
	private int location_id;
	
	@Column(name="category_id")
	private int category_id;
	
	@Column(name="currency_id")
	private int currency_id;
	
	@Column(name="featured_id")
	private int featured_id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="slug")
	private String slug;
	
	@Column(name="description")
	private String description;
	
	@Column(name="price")
	private int price;
	
	@Column(name="negotiable")
	private String negotiable;
	
	@Column(name="hide_phone")
	private String hide_phone;
	
	@Column(name="hide_email")
	private String hide_email;
	
	@Column(name="remaining_auto_renewal")
	private int remaining_auto_renewal;
	
	@Column(name="promo_expire_at")
	private String promo_expire_at;
	
	@Column(name="listing_expire_at")
	private String listing_expire_at;

/*	@ElementCollection
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)*/
	@Column(name="imgpath")
	private String imgpath;
//	private List<String> imgpath=new ArrayList<String>();

	
	@Column(name="status")
	private String status;
	
	@Column(name="created_at")
	private String created_at;
	
	@Column(name="updated_at")
	private String updated_at;
	
	@Column(name="subcat_id")
	private int subcat_id;
	
	@Column(name="sub_subcat_id")
	private int sub_subcat_id;
	
	@Column(name="flag")
	private int flag;
	
	@Column(name="good_usage")
	private String good_usage;

	public Advertisement() {
		//super();
	}

	public Advertisement(int listing_id) {
		super();
		this.listing_id = listing_id;
	}

	

	

	public Advertisement(int listing_id, int package_id, Long user_id, int location_id, int category_id,
			int currency_id, int featured_id, String title, String slug, String description, int price,
			String negotiable, String hide_phone, String hide_email, int remaining_auto_renewal, String promo_expire_at,
			String listing_expire_at, String imgpath, String status, String created_at, String updated_at,
			int subcat_id, int sub_subcat_id, int flag, String good_usage) {
		super();
		this.listing_id = listing_id;
		this.package_id = package_id;
		this.user_id = user_id;
		this.location_id = location_id;
		this.category_id = category_id;
		this.currency_id = currency_id;
		this.featured_id = featured_id;
		this.title = title;
		this.slug = slug;
		this.description = description;
		this.price = price;
		this.negotiable = negotiable;
		this.hide_phone = hide_phone;
		this.hide_email = hide_email;
		this.remaining_auto_renewal = remaining_auto_renewal;
		this.promo_expire_at = promo_expire_at;
		this.listing_expire_at = listing_expire_at;
		this.imgpath = imgpath;
		this.status = status;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.subcat_id = subcat_id;
		this.sub_subcat_id = sub_subcat_id;
		this.flag = flag;
		this.good_usage = good_usage;
	}

	public String getImgpath() {
		return imgpath;
	}

	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}

	public int getListing_id() {
		return listing_id;
	}

	public void setListing_id(int listing_id) {
		this.listing_id = listing_id;
	}

	public int getPackage_id() {
		return package_id;
	}

	public void setPackage_id(int package_id) {
		this.package_id = package_id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public int getLocation_id() {
		return location_id;
	}

	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public int getCurrency_id() {
		return currency_id;
	}

	public void setCurrency_id(int currency_id) {
		this.currency_id = currency_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getNegotiable() {
		return negotiable;
	}

	public void setNegotiable(String negotiable) {
		this.negotiable = negotiable;
	}

	public String getHide_phone() {
		return hide_phone;
	}

	public void setHide_phone(String hide_phone) {
		this.hide_phone = hide_phone;
	}

	public String getHide_email() {
		return hide_email;
	}

	public void setHide_email(String hide_email) {
		this.hide_email = hide_email;
	}

	public int getRemaining_auto_renewal() {
		return remaining_auto_renewal;
	}

	public void setRemaining_auto_renewal(int remaining_auto_renewal) {
		this.remaining_auto_renewal = remaining_auto_renewal;
	}

	public String getPromo_expire_at() {
		return promo_expire_at;
	}

	public void setPromo_expire_at(String promo_expire_at) {
		this.promo_expire_at = promo_expire_at;
	}

	public String getListing_expire_at() {
		return listing_expire_at;
	}

	public void setListing_expire_at(String listing_expire_at) {
		this.listing_expire_at = listing_expire_at;
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
	

	public int getFeatured_id() {
		return featured_id;
	}

	public void setFeatured_id(int featured_id) {
		this.featured_id = featured_id;
	}

	
	public int getSubcat_id() {
		return subcat_id;
	}

	public void setSubcat_id(int subcat_id) {
		this.subcat_id = subcat_id;
	}

	public int getSub_subcat_id() {
		return sub_subcat_id;
	}

	public void setSub_subcat_id(int sub_subcat_id) {
		this.sub_subcat_id = sub_subcat_id;
	}
	
	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	
	public String getGood_usage() {
		return good_usage;
	}

	public void setGood_usage(String good_usage) {
		this.good_usage = good_usage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + category_id;
		result = prime * result + ((created_at == null) ? 0 : created_at.hashCode());
		result = prime * result + currency_id;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + featured_id;
		result = prime * result + flag;
		result = prime * result + ((good_usage == null) ? 0 : good_usage.hashCode());
		result = prime * result + ((hide_email == null) ? 0 : hide_email.hashCode());
		result = prime * result + ((hide_phone == null) ? 0 : hide_phone.hashCode());
		result = prime * result + ((imgpath == null) ? 0 : imgpath.hashCode());
		result = prime * result + ((listing_expire_at == null) ? 0 : listing_expire_at.hashCode());
		result = prime * result + listing_id;
		result = prime * result + location_id;
		result = prime * result + ((negotiable == null) ? 0 : negotiable.hashCode());
		result = prime * result + package_id;
		result = prime * result + price;
		result = prime * result + ((promo_expire_at == null) ? 0 : promo_expire_at.hashCode());
		result = prime * result + remaining_auto_renewal;
		result = prime * result + ((slug == null) ? 0 : slug.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + sub_subcat_id;
		result = prime * result + subcat_id;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((updated_at == null) ? 0 : updated_at.hashCode());
		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
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
		Advertisement other = (Advertisement) obj;
		if (category_id != other.category_id)
			return false;
		if (created_at == null) {
			if (other.created_at != null)
				return false;
		} else if (!created_at.equals(other.created_at))
			return false;
		if (currency_id != other.currency_id)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (featured_id != other.featured_id)
			return false;
		if (flag != other.flag)
			return false;
		if (good_usage == null) {
			if (other.good_usage != null)
				return false;
		} else if (!good_usage.equals(other.good_usage))
			return false;
		if (hide_email == null) {
			if (other.hide_email != null)
				return false;
		} else if (!hide_email.equals(other.hide_email))
			return false;
		if (hide_phone == null) {
			if (other.hide_phone != null)
				return false;
		} else if (!hide_phone.equals(other.hide_phone))
			return false;
		if (imgpath == null) {
			if (other.imgpath != null)
				return false;
		} else if (!imgpath.equals(other.imgpath))
			return false;
		if (listing_expire_at == null) {
			if (other.listing_expire_at != null)
				return false;
		} else if (!listing_expire_at.equals(other.listing_expire_at))
			return false;
		if (listing_id != other.listing_id)
			return false;
		if (location_id != other.location_id)
			return false;
		if (negotiable == null) {
			if (other.negotiable != null)
				return false;
		} else if (!negotiable.equals(other.negotiable))
			return false;
		if (package_id != other.package_id)
			return false;
		if (price != other.price)
			return false;
		if (promo_expire_at == null) {
			if (other.promo_expire_at != null)
				return false;
		} else if (!promo_expire_at.equals(other.promo_expire_at))
			return false;
		if (remaining_auto_renewal != other.remaining_auto_renewal)
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
		if (sub_subcat_id != other.sub_subcat_id)
			return false;
		if (subcat_id != other.subcat_id)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
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
		return true;
	}


	
	
	
	
}
