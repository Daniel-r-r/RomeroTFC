package com.romero.ecommerce.controller;

import com.romero.ecommerce.entity.JwtRequest;
import com.romero.ecommerce.entity.JwtResponse;
import com.romero.ecommerce.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador para manejar las solicitudes relacionadas con la autenticación
 * JWT en la aplicación de comercio electrónico.
 * 
 * @author Daniel Romero
 */
@RestController
@CrossOrigin
public class JwtController {

	@Autowired
	private JwtService jwtService;

	/**
	 * Endpoint para crear un token JWT.
	 * 
	 * @param jwtRequest La solicitud JWT que contiene las credenciales de usuario.
	 * @return Un objeto JwtResponse que contiene el token JWT generado.
	 * @throws Exception Si se produce un error al crear el token JWT.
	 */
	@PostMapping({ "/authenticate" })
	public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
		return jwtService.createJwtToken(jwtRequest);
	}
}
