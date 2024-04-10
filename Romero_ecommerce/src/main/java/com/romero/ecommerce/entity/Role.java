package com.romero.ecommerce.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Clase que representa un rol en la aplicación de comercio electrónico.
 * Contiene el nombre y la descripción del rol.
 * 
 * @author Daniel Romero
 */
@Entity
public class Role {

	@Id
	private String roleName;
	private String roleDescription;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}
}
