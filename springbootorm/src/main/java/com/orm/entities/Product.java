package com.orm.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="jpa_product")
public class Product {

	@Id
	private String pId;
	private String productName;
	
	@ManyToMany(mappedBy="product",fetch=FetchType.EAGER)
	private List <Category> category= new ArrayList<>();
	
	
	public List<Category> getCategory() {
		return category;
	}
	public void setCategory(List<Category> category) {
		this.category = category;
	}
	public Product(String pId, String productName) {
		super();
		this.pId = pId;
		this.productName = productName;
	}
	public Product() {
		super();
	
	}
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
	
}
