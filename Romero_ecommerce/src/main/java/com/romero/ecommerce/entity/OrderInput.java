package com.romero.ecommerce.entity;

import java.util.List;

/**
 * Entidad que representa la entrada de un pedido en la aplicación de comercio
 * electrónico. Contiene información sobre el nombre completo, la dirección
 * completa, el número de contacto, el número de contacto alternativo, el ID de
 * la transacción y la lista de productos y cantidades del pedido.
 * 
 * @autor Daniel Romero
 */
public class OrderInput {

	private String fullName;
	private String fullAddress;
	private String contactNumber;
	private String alternateContactNumber;
	private List<OrderProductQuantity> orderProductQuantityList;

	/**
	 * Obtiene el nombre completo para el pedido.
	 * 
	 * @return el nombre completo
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * Establece el nombre completo para el pedido.
	 * 
	 * @param fullName el nombre completo
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * Obtiene la dirección completa para el pedido.
	 * 
	 * @return la dirección completa
	 */
	public String getFullAddress() {
		return fullAddress;
	}

	/**
	 * Establece la dirección completa para el pedido.
	 * 
	 * @param fullAddress la dirección completa
	 */
	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	/**
	 * Obtiene el número de contacto para el pedido.
	 * 
	 * @return el número de contacto
	 */
	public String getContactNumber() {
		return contactNumber;
	}

	/**
	 * Establece el número de contacto para el pedido.
	 * 
	 * @param contactNumber el número de contacto
	 */
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	/**
	 * Obtiene el número de contacto alternativo para el pedido.
	 * 
	 * @return el número de contacto alternativo
	 */
	public String getAlternateContactNumber() {
		return alternateContactNumber;
	}

	/**
	 * Establece el número de contacto alternativo para el pedido.
	 * 
	 * @param alternateContactNumber el número de contacto alternativo
	 */
	public void setAlternateContactNumber(String alternateContactNumber) {
		this.alternateContactNumber = alternateContactNumber;
	}

	/**
	 * Obtiene la lista de productos y cantidades del pedido.
	 * 
	 * @return la lista de productos y cantidades
	 */
	public List<OrderProductQuantity> getOrderProductQuantityList() {
		return orderProductQuantityList;
	}

	/**
	 * Establece la lista de productos y cantidades del pedido.
	 * 
	 * @param orderProductQuantityList la lista de productos y cantidades
	 */
	public void setOrderProductQuantityList(List<OrderProductQuantity> orderProductQuantityList) {
		this.orderProductQuantityList = orderProductQuantityList;
	}
}
