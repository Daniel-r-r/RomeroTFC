package com.romero.ecommerce.service;

import com.romero.ecommerce.dao.UserDao;
import com.romero.ecommerce.entity.JwtRequest;
import com.romero.ecommerce.entity.JwtResponse;
import com.romero.ecommerce.entity.User;
import com.romero.ecommerce.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Servicio para la gestión de operaciones relacionadas con JWT en la aplicación
 * de comercio electrónico. Proporciona métodos para autenticar usuarios,
 * generar tokens JWT y cargar detalles de usuario. También implementa
 * UserDetailsService para la autenticación de Spring Security.
 * 
 * @author Daniel Romero
 */
@Service
public class JwtService implements UserDetailsService {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private UserDao userDao;

	@Autowired
	private AuthenticationManager authenticationManager;

	/**
	 * Crea un nuevo token JWT basado en las credenciales proporcionadas en la
	 * solicitud JWT.
	 * 
	 * @param jwtRequest La solicitud JWT que contiene las credenciales de usuario.
	 * @return Un objeto JwtResponse que contiene el token JWT generado y detalles
	 *         del usuario.
	 * @throws Exception Si ocurre un error durante la autenticación o generación
	 *                   del token.
	 */
	public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception {
		String userName = jwtRequest.getUserName();
		String userPassword = jwtRequest.getUserPassword();
		authenticate(userName, userPassword);

		UserDetails userDetails = loadUserByUsername(userName);
		String newGeneratedToken = jwtUtil.generateToken(userDetails);

		User user = userDao.findById(userName).get();
		return new JwtResponse(user, newGeneratedToken);
	}

	/**
	 * Carga los detalles del usuario para la autenticación de Spring Security.
	 * 
	 * @param username El nombre de usuario del usuario.
	 * @return Detalles del usuario para la autenticación de Spring Security.
	 * @throws UsernameNotFoundException Si el usuario no está registrado.
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findById(username).orElse(null);

		if (user != null) {
			return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getUserPassword(),
					getAuthority(user));
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}

	/**
	 * Obtiene las autoridades (roles) del usuario.
	 * 
	 * @param user El usuario del que se obtienen las autoridades.
	 * @return Las autoridades del usuario.
	 */
	private Set<SimpleGrantedAuthority> getAuthority(User user) {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		user.getRole().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
		});
		return authorities;
	}

	/**
	 * Autentica al usuario utilizando el AuthenticationManager de Spring Security.
	 * 
	 * @param userName     El nombre de usuario del usuario.
	 * @param userPassword La contraseña del usuario.
	 * @throws Exception Si la autenticación falla debido a credenciales inválidas o
	 *                   usuario deshabilitado.
	 */
	private void authenticate(String userName, String userPassword) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, userPassword));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
