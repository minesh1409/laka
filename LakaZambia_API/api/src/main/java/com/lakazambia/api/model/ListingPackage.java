package com.lakazambia.api.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="ea_listing_package")
public class ListingPackage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int package_id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="price")
	private int price;
	
	@Column(name="listing_days")
	private int listing_days;
	
	@Column(name="promo_days")
	private int promo_days;
	
	@Column(name="promo_show_featured_area")
	private String promo_show_featured_area;
	
	@Column(name="promo_show_at_top")
	private String promo_show_at_top;
	
	@Column(name="promo_sign")
	private String promo_sign;

	@Column(name="recommended_sign")
	private String recommended_sign;

	@Column(name="auto_renewal")
	private int auto_renewal;
	
	@Column(name="created_at")
	private String created_at;
	
	@Column(name="updated_at")
	private String updated_at;

	public ListingPackage() {
		super();
	}

	public ListingPackage(int package_id) {
		super();
		this.package_id = package_id;
	}

	

	public ListingPackage(int package_id, String title, int price, int listing_days, int promo_days,
			String promo_show_featured_area, String promo_show_at_top, String promo_sign, String recommended_sign,
			int auto_renewal, String created_at, String updated_at) {
		super();
		this.package_id = package_id;
		this.title = title;
		this.price = price;
		this.listing_days = listing_days;
		this.promo_days = promo_days;
		this.promo_show_featured_area = promo_show_featured_area;
		this.promo_show_at_top = promo_show_at_top;
		this.promo_sign = promo_sign;
		this.recommended_sign = recommended_sign;
		this.auto_renewal = auto_renewal;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	public int getPackage_id() {
		return package_id;
	}

	public void setPackage_id(int package_id) {
		this.package_id = package_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getListing_days() {
		return listing_days;
	}

	public void setListing_days(int listing_days) {
		this.listing_days = listing_days;
	}

	public int getPromo_days() {
		return promo_days;
	}

	public void setPromo_days(int promo_days) {
		this.promo_days = promo_days;
	}

	public String getPromo_show_featured_area() {
		return promo_show_featured_area;
	}

	public void setPromo_show_featured_area(String promo_show_featured_area) {
		this.promo_show_featured_area = promo_show_featured_area;
	}

	public String getPromo_show_at_top() {
		return promo_show_at_top;
	}

	public void setPromo_show_at_top(String promo_show_at_top) {
		this.promo_show_at_top = promo_show_at_top;
	}

	public String getPromo_sign() {
		return promo_sign;
	}

	public void setPromo_sign(String promo_sign) {
		this.promo_sign = promo_sign;
	}

	public String getRecommended_sign() {
		return recommended_sign;
	}

	public void setRecommended_sign(String recommended_sign) {
		this.recommended_sign = recommended_sign;
	}

	public int getAuto_renewal() {
		return auto_renewal;
	}

	public void setAuto_renewal(int auto_renewal) {
		this.auto_renewal = auto_renewal;
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
		result = prime * result + auto_renewal;
		result = prime * result + ((created_at == null) ? 0 : created_at.hashCode());
		result = prime * result + listing_days;
		result = prime * result + package_id;
		result = prime * result + price;
		result = prime * result + promo_days;
		result = prime * result + ((promo_show_at_top == null) ? 0 : promo_show_at_top.hashCode());
		result = prime * result + ((promo_show_featured_area == null) ? 0 : promo_show_featured_area.hashCode());
		result = prime * result + ((promo_sign == null) ? 0 : promo_sign.hashCode());
		result = prime * result + ((recommended_sign == null) ? 0 : recommended_sign.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		ListingPackage other = (ListingPackage) obj;
		if (auto_renewal != other.auto_renewal)
			return false;
		if (created_at == null) {
			if (other.created_at != null)
				return false;
		} else if (!created_at.equals(other.created_at))
			return false;
		if (listing_days != other.listing_days)
			return false;
		if (package_id != other.package_id)
			return false;
		if (price != other.price)
			return false;
		if (promo_days != other.promo_days)
			return false;
		if (promo_show_at_top == null) {
			if (other.promo_show_at_top != null)
				return false;
		} else if (!promo_show_at_top.equals(other.promo_show_at_top))
			return false;
		if (promo_show_featured_area == null) {
			if (other.promo_show_featured_area != null)
				return false;
		} else if (!promo_show_featured_area.equals(other.promo_show_featured_area))
			return false;
		if (promo_sign == null) {
			if (other.promo_sign != null)
				return false;
		} else if (!promo_sign.equals(other.promo_sign))
			return false;
		if (recommended_sign == null) {
			if (other.recommended_sign != null)
				return false;
		} else if (!recommended_sign.equals(other.recommended_sign))
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
		return true;
	}

	


}
