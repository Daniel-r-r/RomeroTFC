package com.romero.ecommerce.entity;

/**
 * Clase que representa la respuesta JWT en la aplicación de comercio
 * electrónico. Contiene el usuario y el token JWT generado para la
 * autenticación.
 * 
 * @author Daniel Romero
 */
public class JwtResponse {

	private User user;
	private String jwtToken;

	public JwtResponse(User user, String jwtToken) {
		this.user = user;
		this.jwtToken = jwtToken;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}
}
