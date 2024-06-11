package com.romero.ecommerce.dao;

import com.romero.ecommerce.entity.OrderDetail;
import com.romero.ecommerce.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * DAO para gestionar las operaciones CRUD de los detalles de los pedidos.
 * Proporciona métodos para encontrar pedidos por usuario y por estado.
 * 
 * @autor Daniel Romero
 */
public interface OrderDetailDao extends CrudRepository<OrderDetail, Integer> {

	/**
	 * Encuentra los detalles del pedido por usuario.
	 * 
	 * @param user el usuario del cual se desean obtener los pedidos
	 * @return una lista de detalles del pedido asociados con el usuario
	 *         proporcionado
	 */
	public List<OrderDetail> findByUser(User user);

	/**
	 * Encuentra los detalles del pedido por estado.
	 * 
	 * @param status el estado de los pedidos que se desean obtener
	 * @return una lista de detalles del pedido que coinciden con el estado
	 *         proporcionado
	 */
	public List<OrderDetail> findByOrderStatus(String status);
}
