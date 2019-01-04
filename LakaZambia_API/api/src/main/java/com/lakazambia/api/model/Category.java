package com.lakazambia.api.model;

import java.io.Serializable;



import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;



@Entity
@Table(name="ea_category")
public class Category implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -351743280430692151L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="category_id")
	private int category_id;
	
	@Column(name="parent_id")
	private int parent_id=1;
	
	@Column(name="name")
	private String name;
	
	@Column(name="slug")
	private String slug;
	
	@Column(name="icon")
	private String icon;
	
	@Column(name="description")
	private String description;
	
	@Column(name="short_name")
	private String short_name;
	
	@Column(name="sort_order")
	private int sort_order;
	
	@Column(name="created_at")
	private String created_at;
	
	@Column(name="updated_at")
	private String updated_at;
	
	/*
	@OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "subCat")
    private Set<SubCategory> subcat = new HashSet<>();*/

	public Category() {
		super();
	}

	public Category(int parent_id) {
		super();
		this.parent_id = parent_id;
	}


	public Category(int category_id, int parent_id, String name, String slug, String icon, String description,
			String short_name, int sort_order, String created_at, String updated_at) {
		super();
		this.category_id = category_id;
		this.parent_id = parent_id;
		this.name = name;
		this.slug = slug;
		this.icon = icon;
		this.description = description;
		this.short_name = short_name;
		this.sort_order = sort_order;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public int getParent_id() {
		return parent_id;
	}

	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getShort_name() {
		return short_name;
	}

	public void setShort_name(String short_name) {
		this.short_name = short_name;
	}
	
	

}
