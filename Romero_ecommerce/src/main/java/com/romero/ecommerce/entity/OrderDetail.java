package com.romero.ecommerce.entity;

import javax.persistence.*;

/**
 * Entidad que representa los detalles de un pedido en la aplicación de comercio electrónico.
 * Contiene información sobre el pedido, el producto asociado, el usuario que realizó el pedido y detalles de la transacción.
 * 
 * @autor Daniel Romero
 */
@Entity
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderId;
    private String orderFullName;
    private String orderFullOrder;
    private String orderContactNumber;
    private String orderAlternateContactNumber;
    private String orderStatus;
    private Double orderAmount;

    @OneToOne
    private Product product;

    @OneToOne
    private User user;
    
    private String transactionId;

    /**
     * Constructor por defecto.
     */
    public OrderDetail() {
    }

    /**
     * Constructor que inicializa un objeto OrderDetail con los valores proporcionados.
     * 
     * @param orderFullName nombre completo para el pedido
     * @param orderFullOrder detalles completos del pedido
     * @param orderContactNumber número de contacto del pedido
     * @param orderAlternateContactNumber número de contacto alternativo del pedido
     * @param orderStatus estado del pedido
     * @param orderAmount monto del pedido
     * @param product producto asociado al pedido
     * @param user usuario que realizó el pedido
     * @param transactionId ID de la transacción del pedido
     */
    public OrderDetail(String orderFullName, String orderFullOrder, String orderContactNumber, String orderAlternateContactNumber, String orderStatus, Double orderAmount, Product product, User user) {
        this.orderFullName = orderFullName;
        this.orderFullOrder = orderFullOrder;
        this.orderContactNumber = orderContactNumber;
        this.orderAlternateContactNumber = orderAlternateContactNumber;
        this.orderStatus = orderStatus;

    }

    /**
     * Obtiene el ID de la transacción del pedido.
     * 
     * @return el ID de la transacción
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * Establece el ID de la transacción del pedido.
     * 
     * @param transactionId el ID de la transacción
     */
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    /**
     * Obtiene el producto asociado al pedido.
     * 
     * @return el producto
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Establece el producto asociado al pedido.
     * 
     * @param product el producto
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Obtiene el usuario que realizó el pedido.
     * 
     * @return el usuario
     */
    public User getUser() {
        return user;
    }

    /**
     * Establece el usuario que realizó el pedido.
     * 
     * @param user el usuario
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Obtiene el ID del pedido.
     * 
     * @return el ID del pedido
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * Establece el ID del pedido.
     * 
     * @param orderId el ID del pedido
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * Obtiene el nombre completo para el pedido.
     * 
     * @return el nombre completo del pedido
     */
    public String getOrderFullName() {
        return orderFullName;
    }

    /**
     * Establece el nombre completo para el pedido.
     * 
     * @param orderFullName el nombre completo del pedido
     */
    public void setOrderFullName(String orderFullName) {
        this.orderFullName = orderFullName;
    }

    /**
     * Obtiene los detalles completos del pedido.
     * 
     * @return los detalles completos del pedido
     */
    public String getOrderFullOrder() {
        return orderFullOrder;
    }

    /**
     * Establece los detalles completos del pedido.
     * 
     * @param orderFullOrder los detalles completos del pedido
     */
    public void setOrderFullOrder(String orderFullOrder) {
        this.orderFullOrder = orderFullOrder;
    }

    /**
     * Obtiene el número de contacto del pedido.
     * 
     * @return el número de contacto del pedido
     */
    public String getOrderContactNumber() {
        return orderContactNumber;
    }

    /**
     * Establece el número de contacto del pedido.
     * 
     * @param orderContactNumber el número de contacto del pedido
     */
    public void setOrderContactNumber(String orderContactNumber) {
        this.orderContactNumber = orderContactNumber;
    }

    /**
     * Obtiene el número de contacto alternativo del pedido.
     * 
     * @return el número de contacto alternativo del pedido
     */
    public String getOrderAlternateContactNumber() {
        return orderAlternateContactNumber;
    }

    /**
     * Establece el número de contacto alternativo del pedido.
     * 
     * @param orderAlternateContactNumber el número de contacto alternativo del pedido
     */
    public void setOrderAlternateContactNumber(String orderAlternateContactNumber) {
        this.orderAlternateContactNumber = orderAlternateContactNumber;
    }

    /**
     * Obtiene el estado del pedido.
     * 
     * @return el estado del pedido
     */
    public String getOrderStatus() {
        return orderStatus;
    }

    /**
     * Establece el estado del pedido.
     * 
     * @param orderStatus el estado del pedido
     */
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * Obtiene el monto del pedido.
     * 
     * @return el monto del pedido
     */
    public Double getOrderAmount() {
        return orderAmount;
    }

    /**
     * Establece el monto del pedido.
     * 
     * @param orderAmount el monto del pedido
     */
    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }
}
