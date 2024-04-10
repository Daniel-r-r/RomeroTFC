package com.romero.ecommerce.entity;

/**
 * Clase que representa una solicitud JWT en la aplicación de comercio
 * electrónico. Contiene el nombre de usuario y la contraseña del usuario para
 * la autenticación.
 * 
 * @author Daniel Romero
 */
public class JwtRequest {

	private String userName;
	private String userPassword;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
}
