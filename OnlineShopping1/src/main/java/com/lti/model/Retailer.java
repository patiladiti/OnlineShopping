package com.lti.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "retailer")
public class Retailer {
	@Id
	@Column(name = "retailer_id")
	private int retailerId;
	@Column(name = "retailer_name")
	private String retailerName;
	@Column(name = "email_id")
	private String emailId;
	@Column(name = "permission")
	private String permission;
	@Column(name = "password")
	private String password;
	
	@ManyToMany(mappedBy="retailer")
	private Set<Product> products;

	public Retailer() {
		super();
	}

	public Retailer(int retailerId, String retailerName, String emailId, String permission, String password) {
		super();
		this.retailerId = retailerId;
		this.retailerName = retailerName;
		this.emailId = emailId;
		this.permission = permission;
		this.password = password;
		this.products = products;
	}

	public int getRetailerId() {
		return retailerId;
	}

	public void setRetailerId(int retailerId) {
		this.retailerId = retailerId;
	}

	public String getRetailerName() {
		return retailerName;
	}

	public void setRetailerName(String retailerName) {
		this.retailerName = retailerName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Retailer [retailerId=" + retailerId + ", retailerName=" + retailerName + ", emailId=" + emailId
				+ ", permission=" + permission + ", password=" + password + ", products=" + products + "]";
	}

}
