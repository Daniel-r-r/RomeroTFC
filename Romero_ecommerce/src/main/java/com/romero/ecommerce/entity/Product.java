package com.romero.ecommerce.entity;

import javax.persistence.*;

/**
 * Clase de entidad que representa un producto en la aplicación de comercio electrónico.
 * @author Daniel Romero
 */
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;

	private String productName;
	private String productDescription;
	private Double productDiscountedPrice;
	private Double productActualPrice;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Double getProductDiscountedPrice() {
		return productDiscountedPrice;
	}

	public void setProductDiscountedPrice(Double productDiscountedPrice) {
		this.productDiscountedPrice = productDiscountedPrice;
	}

	public Double getProductActualPrice() {
		return productActualPrice;
	}

	public void setProductActualPrice(Double productActualPrice) {
		this.productActualPrice = productActualPrice;
	}
}
