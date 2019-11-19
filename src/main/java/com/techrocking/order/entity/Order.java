package com.techrocking.order.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "orders")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull
	@Id
	@Column(name = "id")
	private Long id;

	@NotNull
	@Column(name = "customer_name")
	private String customerName;

	@NotNull
	@Column(name = "customer_phone")
	private String customerPhone;
	
	@NotNull
	@Column(name = "item_name")
	private String itemName;
	
	@NotNull
	@Column(name = "item_category")
	private String itemCategory;
	
	@NotNull
	@Column(name = "item_subcategory")
	private String itemSubcategory;
	
	@NotNull
	@Column(name = "quantity")
	private Long quantity;

	@NotNull
	@Column(name = "creation_date")
	private LocalDateTime creationDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public String getItemSubcategory() {
		return itemSubcategory;
	}

	public void setItemSubcategory(String itemSubcategory) {
		this.itemSubcategory = itemSubcategory;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	

}
