package com.romero.ecommerce.entity;

/**
 * Entidad que representa la cantidad de un producto en un pedido en la
 * aplicación de comercio electrónico. Contiene información sobre el ID del
 * producto y la cantidad del mismo en el pedido.
 * 
 * @autor Daniel Romero
 */
public class OrderProductQuantity {

	private Integer productId;
	private Integer quantity;

	/**
	 * Obtiene el ID del producto.
	 * 
	 * @return el ID del producto
	 */
	public Integer getProductId() {
		return productId;
	}

	/**
	 * Establece el ID del producto.
	 * 
	 * @param productId el ID del producto
	 */
	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	/**
	 * Obtiene la cantidad del producto en el pedido.
	 * 
	 * @return la cantidad del producto
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * Establece la cantidad del producto en el pedido.
	 * 
	 * @param quantity la cantidad del producto
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
