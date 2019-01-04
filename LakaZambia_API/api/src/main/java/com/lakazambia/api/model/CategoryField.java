package com.lakazambia.api.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;



@Entity
@Table(name="ea_category_field")
public class CategoryField implements Serializable{

		/**
	 * 
	 */
	private static final long serialVersionUID = 3949723493732157543L;

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="field_id")
		private int field_id;
		
		@Column(name="type_id",insertable=false,updatable=false)
		private int type_id;
		
		@Column(name="category_id",insertable=false,updatable=false)
		private int category_id;
		
		@Column(name="label")
		private String label;
		
		@Column(name="unit")
		private String unit;
		
		@Column(name="default_value")
		private String default_value;
		
		@Column(name="help_text")
		private String help_text;
		
		@Column(name="required")
		private String required;
		
		@Column(name="sort_order")
		private int sort_order;
		
		@Column(name="status")
		private String status;
		
		@Column(name="created_at")
		private String created_at;
		
		@Column(name="updated_at")
		private String updated_at;

	/*	@OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "type_id")
		private CategoryType categorytype;
		
		@OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "category_id")
		private Category category;*/
		
		

		public CategoryField() {
			//super();
		}



		public CategoryField(int field_id) {
			//super();
			this.field_id = field_id;
		}



		public CategoryField(int field_id, int type_id, int category_id, String label, String unit,
				String default_value, String help_text, String required, int sort_order, String status,
				String created_at, String updated_at) {
			//super();
			this.field_id = field_id;
			this.type_id = type_id;
			this.category_id = category_id;
			this.label = label;
			this.unit = unit;
			this.default_value = default_value;
			this.help_text = help_text;
			this.required = required;
			this.sort_order = sort_order;
			this.status = status;
			this.created_at = created_at;
			this.updated_at = updated_at;
		
		}



		public int getField_id() {
			return field_id;
		}



		public void setField_id(int field_id) {
			this.field_id = field_id;
		}



		public int getType_id() {
			return type_id;
		}



		public void setType_id(int type_id) {
			this.type_id = type_id;
		}



		public int getCategory_id() {
			return category_id;
		}



		public void setCategory_id(int category_id) {
			this.category_id = category_id;
		}



		public String getLabel() {
			return label;
		}



		public void setLabel(String label) {
			this.label = label;
		}



		public String getUnit() {
			return unit;
		}



		public void setUnit(String unit) {
			this.unit = unit;
		}



		public String getDefault_value() {
			return default_value;
		}



		public void setDefault_value(String default_value) {
			this.default_value = default_value;
		}



		public String getHelp_text() {
			return help_text;
		}



		public void setHelp_text(String help_text) {
			this.help_text = help_text;
		}



		public String getRequired() {
			return required;
		}



		public void setRequired(String required) {
			this.required = required;
		}



		public int getSort_order() {
			return sort_order;
		}



		public void setSort_order(int sort_order) {
			this.sort_order = sort_order;
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



		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + category_id;
			result = prime * result + ((created_at == null) ? 0 : created_at.hashCode());
			result = prime * result + ((default_value == null) ? 0 : default_value.hashCode());
			result = prime * result + field_id;
			result = prime * result + ((help_text == null) ? 0 : help_text.hashCode());
			result = prime * result + ((label == null) ? 0 : label.hashCode());
			result = prime * result + ((required == null) ? 0 : required.hashCode());
			result = prime * result + sort_order;
			result = prime * result + ((status == null) ? 0 : status.hashCode());
			result = prime * result + type_id;
			result = prime * result + ((unit == null) ? 0 : unit.hashCode());
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
			CategoryField other = (CategoryField) obj;
			if (category_id != other.category_id)
				return false;
			if (created_at == null) {
				if (other.created_at != null)
					return false;
			} else if (!created_at.equals(other.created_at))
				return false;
			if (default_value == null) {
				if (other.default_value != null)
					return false;
			} else if (!default_value.equals(other.default_value))
				return false;
			if (field_id != other.field_id)
				return false;
			if (help_text == null) {
				if (other.help_text != null)
					return false;
			} else if (!help_text.equals(other.help_text))
				return false;
			if (label == null) {
				if (other.label != null)
					return false;
			} else if (!label.equals(other.label))
				return false;
			if (required == null) {
				if (other.required != null)
					return false;
			} else if (!required.equals(other.required))
				return false;
			if (sort_order != other.sort_order)
				return false;
			if (status == null) {
				if (other.status != null)
					return false;
			} else if (!status.equals(other.status))
				return false;
			if (type_id != other.type_id)
				return false;
			if (unit == null) {
				if (other.unit != null)
					return false;
			} else if (!unit.equals(other.unit))
				return false;
			if (updated_at == null) {
				if (other.updated_at != null)
					return false;
			} else if (!updated_at.equals(other.updated_at))
				return false;
			return true;
		}






	
		
		
		
}
