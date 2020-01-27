package com.lti.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Category_Product")
public class CategoryProduct {

	@Id
	@Column(name = "category_id")
	private int categoryId;
	@Column(name = "category_name")
	private String category_name;

	public CategoryProduct() {
		super();

	}

	public CategoryProduct(int categoryId, String category_name) {
		super();
		this.categoryId = categoryId;
		this.category_name = category_name;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	@Override
	public String toString() {
		return "CategoryProduct [categoryId=" + categoryId + ", category_name=" + category_name + "]";
	}

}
