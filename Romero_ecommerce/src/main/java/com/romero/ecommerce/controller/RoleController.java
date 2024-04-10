package com.romero.ecommerce.controller;

import com.romero.ecommerce.entity.Role;
import com.romero.ecommerce.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador para manejar las solicitudes relacionadas con los roles en la
 * aplicación de comercio electrónico.
 * 
 * @author Daniel Romero
 */
@RestController
public class RoleController {

	@Autowired
	private RoleService roleService;

	/**
	 * Endpoint para crear un nuevo rol.
	 * 
	 * @param role El objeto Role que representa el nuevo rol a crear.
	 * @return El objeto Role creado.
	 */
	@PostMapping({ "/createNewRole" })
	public Role createNewRole(@RequestBody Role role) {
		return roleService.createNewRole(role);
	}
}
