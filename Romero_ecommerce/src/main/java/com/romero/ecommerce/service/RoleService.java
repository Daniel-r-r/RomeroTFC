package com.romero.ecommerce.service;

import com.romero.ecommerce.dao.RoleDao;
import com.romero.ecommerce.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicio para la gestión de operaciones relacionadas con los roles en la
 * aplicación de comercio electrónico. Proporciona métodos para crear nuevos
 * roles.
 * 
 * @author Daniel Romero
 */
@Service
public class RoleService {

	@Autowired
	private RoleDao roleDao;

	/**
	 * Crea un nuevo rol en la base de datos.
	 * 
	 * @param role El objeto Role que representa el nuevo rol a crear.
	 * @return El objeto Role creado.
	 */
	public Role createNewRole(Role role) {
		return roleDao.save(role);
	}
}
