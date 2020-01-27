package com.lti.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Product1")
public class Product {
	@Id
	@Column(name = "prod_id")
	private int productId;
	@Column(name = "prod_name")
	private String productName;
	@Column(name = "price")
	private double price;
	@Column(name = "prod_status")
	private String productStatus;
	// @Column(name = "brand_id")
	// private int brandId;

	@Column(name = "retailer_id")
	private int retailerId;

	public Product(int productId, String productName, double price, String productStatus, int retailerId,
			int productQuantity) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.productStatus = productStatus;
		this.retailerId = retailerId;
		this.productQuantity = productQuantity;
	}

	@Column(name = "quantity")
	private int productQuantity;

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "retailer_id")
	private List<Retailer> retailer;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id")
	private CategoryProduct category;

	@ManyToOne
	@JoinColumn(name = "brand_id")
	private Brand brand;

	public Product() {
		super();
	}

	public Product(int productId, String productName, double price, String productStatus, Brand brand, int retailerId,
			int productQuantity) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.productStatus = productStatus;
		this.brand = brand;

		this.retailerId = retailerId;
		this.productQuantity = productQuantity;
		this.retailer = retailer;
		this.category = category;

	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}

	public Brand getBrandId() {
		return brand;
	}

	public void setBrandId(int brandId) {
		this.brand = brand;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public List<Retailer> getRetailer() {
		return retailer;
	}

	public void setRetailer(Retailer retailer1) {
		this.retailer = (List<Retailer>) retailer1;
	}

	public CategoryProduct getCategory() {
		return category;
	}

	public void setCategory(CategoryProduct category) {
		this.category = category;
	}

	public int getRetailerId() {
		return retailerId;
	}

	public void setRetailerId(int retailerId) {
		this.retailerId = retailerId;
	}

	public void setRetailer(List<Retailer> retailer) {
		this.retailer = retailer;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price
				+ ", productStatus=" + productStatus + ", brandId=" + brand + ", productQuantity=" + productQuantity
				+ ", retailer=" + retailer + "]";
	}

}
