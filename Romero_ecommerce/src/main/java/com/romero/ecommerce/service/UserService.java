package com.romero.ecommerce.service;

import com.romero.ecommerce.dao.RoleDao;
import com.romero.ecommerce.dao.UserDao;
import com.romero.ecommerce.entity.Role;
import com.romero.ecommerce.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Servicio para la gestión de operaciones relacionadas con los usuarios en la
 * aplicación de comercio electrónico. Proporciona métodos para inicializar
 * roles y usuarios, registrar nuevos usuarios y codificar contraseñas.
 * 
 * @author Daniel Romero
 */
@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private PasswordEncoder passwordEncoder;

	/**
	 * Inicializa roles y usuarios predeterminados en la base de datos al iniciar la
	 * aplicación.
	 * 
	 * Se crea un rol de administrador y un rol de usuario. Se crea un usuario
	 * administrador con el rol de administrador y un usuario normal con el rol de
	 * usuario.
	 */
	public void initRoleAndUser() {
		Role adminRole = new Role();
		adminRole.setRoleName("Admin");
		adminRole.setRoleDescription("Admin role");
		roleDao.save(adminRole);

		Role userRole = new Role();
		userRole.setRoleName("User");
		userRole.setRoleDescription("Default role for newly created record");
		roleDao.save(userRole);

		User adminUser = new User();
		adminUser.setUserName("admin123");
		adminUser.setUserPassword(getEncodedPassword("admin@pass"));
		adminUser.setUserFirstName("admin");
		adminUser.setUserLastName("admin");
		Set<Role> adminRoles = new HashSet<>();
		adminRoles.add(adminRole);
		adminUser.setRole(adminRoles);
		userDao.save(adminUser);

		User user = new User();
		user.setUserName("Daniel");
		user.setUserPassword(getEncodedPassword("611998"));
		user.setUserFirstName("Daniel");
		user.setUserLastName("Romero");
		Set<Role> userRoles = new HashSet<>();
		userRoles.add(userRole);
		user.setRole(userRoles);
		userDao.save(user);

//        User user = new User();
//        user.setUserName("nombre");
//        user.setUserPassword(getEncodedPassword("contraseña"));
//        user.setUserFirstName("nombre");
//        user.setUserLastName("apellido");
//        Set<Role> userRoles = new HashSet<>();
//        userRoles.add(rol);
//        user.setRole(rol);
//        userDao.save(user);
	}

	/**
	 * Registra un nuevo usuario en la base de datos.
	 * 
	 * @param user El objeto User que representa el nuevo usuario a registrar.
	 * @return El objeto User creado.
	 */
	public User registerNewUser(User user) {
		Role role = roleDao.findById("User").get();
		Set<Role> userRoles = new HashSet<>();
		userRoles.add(role);
		user.setRole(userRoles);
		user.setUserPassword(getEncodedPassword(user.getUserPassword()));

		return userDao.save(user);
	}

	/**
	 * Codifica la contraseña utilizando el PasswordEncoder configurado en la
	 * aplicación.
	 * 
	 * @param password La contraseña en texto plano.
	 * @return La contraseña codificada.
	 */
	public String getEncodedPassword(String password) {
		return passwordEncoder.encode(password);
	}
}