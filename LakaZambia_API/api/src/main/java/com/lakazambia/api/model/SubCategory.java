package com.lakazambia.api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "ea_sub_category")
public class SubCategory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3879492141225345830L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "subcat_id")
	private int subcat_id;

	@Column(name = "name")
	private String name;

	@Column(name = "short_name")
	private String short_name;

	@Column(name = "status")
	private String status;

	@Column(name = "created_at")
	private String created_at;

	@Column(name = "updated_at")
	private String updated_at;

	@Column(name="category_id")
	private int cat_id;
	
	@Column(name="flag")
	private int flag;
	
/*
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cat_id", nullable = false)
	private SubCategory subCat;
	
	
	@OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "subsubCat")
    private Set<SubSubCategory> subsubcat = new HashSet<>();*/

	public SubCategory() {
		super();
	}

	public SubCategory(int subcat_id) {
		super();
		this.subcat_id = subcat_id;
	}

	



	public SubCategory(int subcat_id, String name, String short_name, String status, String created_at,
			String updated_at, int cat_id, int flag) {
		super();
		this.subcat_id = subcat_id;
		this.name = name;
		this.short_name = short_name;
		this.status = status;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.cat_id = cat_id;
		this.flag = flag;
	}

	public int getSubcat_id() {
		return subcat_id;
	}

	public void setSubcat_id(int subcat_id) {
		this.subcat_id = subcat_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShort_name() {
		return short_name;
	}

	public void setShort_name(String short_name) {
		this.short_name = short_name;
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

	public int getCat_id() {
		return cat_id;
	}

	public void setCat_id(int cat_id) {
		this.cat_id = cat_id;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	



}
