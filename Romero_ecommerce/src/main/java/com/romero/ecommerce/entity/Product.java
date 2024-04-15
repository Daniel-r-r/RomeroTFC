package com.romero.ecommerce.entity;

import java.util.Set;

import javax.persistence.*;

/**
 * Clase de entidad que representa un producto en la aplicación de comercio
 * electrónico.
 * 
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
	
	@OneToMany (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "product_images",
			joinColumns = {
				@JoinColumn(name = "product_id")
			},
			inverseJoinColumns = {
				@JoinColumn(name = "image_id")
			}
	)
	
	private Set<ImageModel> productImages;
	

	public Set<ImageModel> getProductImages() {
		return productImages;
	}

	public void setProductImages(Set<ImageModel> productImages) {
		this.productImages = productImages;
	}

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
