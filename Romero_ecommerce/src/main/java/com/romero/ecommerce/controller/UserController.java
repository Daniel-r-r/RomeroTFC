package com.romero.ecommerce.controller;

import com.romero.ecommerce.entity.User;
import com.romero.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * Controlador para manejar las solicitudes relacionadas con los usuarios en la
 * aplicación de comercio electrónico.
 * 
 * @author Daniel Romero
 */
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostConstruct
	public void initRoleAndUser() {
		userService.initRoleAndUser();
	}

	/**
	 * Endpoint para registrar un nuevo usuario.
	 * 
	 * @param user El objeto User que representa al nuevo usuario a registrar.
	 * @return El objeto User creado.
	 */
	@PostMapping({ "/registerNewUser" })
	public User registerNewUser(@RequestBody User user) {
		return userService.registerNewUser(user);
	}

	/**
	 * Endpoint accesible solo para el rol de Admin.
	 * 
	 * @return Un mensaje indicando que la URL solo es accesible para el
	 *         administrador.
	 */
	@GetMapping({ "/forAdmin" })
	@PreAuthorize("hasRole('Admin')")
	public String forAdmin() {
		return "This URL is only accessible to the admin";
	}

	/**
	 * Endpoint accesible solo para el rol de User.
	 * 
	 * @return Un mensaje indicando que la URL solo es accesible para el usuario.
	 */
	@GetMapping({ "/forUser" })
	@PreAuthorize("hasRole('User')")
	public String forUser() {
		return "This URL is only accessible to the user";
	}
}
