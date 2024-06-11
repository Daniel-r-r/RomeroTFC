package com.romero.ecommerce.controller;

import com.romero.ecommerce.entity.OrderDetail;
import com.romero.ecommerce.entity.OrderInput;
import com.romero.ecommerce.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para gestionar los detalles de los pedidos en la aplicación de comercio electrónico.
 * Proporciona endpoints para realizar pedidos, recuperar detalles de pedidos,
 * marcar pedidos como entregados y crear transacciones.
 * 
 * @autor Daniel Romero
 */
@RestController
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;

    /**
     * Realiza un pedido basado en la entrada del pedido proporcionada y el tipo de pago.
     * 
     * @param isSingleProductCheckout indica si el pedido es para un solo producto
     * @param orderInput los detalles del pedido
     */
    @PreAuthorize("hasRole('User')")
    @PostMapping({"/placeOrder/{isSingleProductCheckout}"})
    public void placeOrder(@PathVariable(name = "isSingleProductCheckout") boolean isSingleProductCheckout,
            @RequestBody OrderInput orderInput) {
        orderDetailService.placeOrder(orderInput, isSingleProductCheckout);
    }

    /**
     * Recupera los detalles de los pedidos realizados por el usuario actual.
     * 
     * @return una lista de detalles de pedidos
     */
    @PreAuthorize("hasRole('User')")
    @GetMapping({"/getOrderDetails"})
    public List<OrderDetail> getOrderDetails() {
        return orderDetailService.getOrderDetails();
    }

    /**
     * Recupera todos los detalles de los pedidos con el estado especificado.
     * Este endpoint solo es accesible para usuarios administradores.
     * 
     * @param status el estado de los pedidos a recuperar
     * @return una lista de detalles de pedidos que coinciden con el estado especificado
     */
    @PreAuthorize("hasRole('Admin')")
    @GetMapping({"/getAllOrderDetails/{status}"})
    public List<OrderDetail> getAllOrderDetails(@PathVariable(name = "status") String status) {
        return orderDetailService.getAllOrderDetails(status);
    }

    /**
     * Marca el pedido especificado como entregado.
     * Este endpoint solo es accesible para usuarios administradores.
     * 
     * @param orderId el ID del pedido a marcar como entregado
     */
    @PreAuthorize("hasRole('Admin')")
    @GetMapping({"/markOrderAsDelivered/{orderId}"})
    public void markOrderAsDelivered(@PathVariable(name = "orderId") Integer orderId) {
        orderDetailService.markOrderAsDelivered(orderId);
    }

    /**
     * Crea una transacción por la cantidad especificada.
     * 
     * @param amount la cantidad de la transacción
     * @return los detalles de la transacción
     */

}
