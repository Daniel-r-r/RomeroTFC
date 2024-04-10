package com.romero.ecommerce.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Clase utilitaria para la manipulación de tokens JWT en la aplicación de
 * comercio electrónico. Proporciona métodos para generar, validar y obtener
 * información de los tokens JWT.
 * 
 * @author Daniel Romero
 */
@Component
public class JwtUtil {

	private static final String SECRET_KEY = "DanielRomero_2DAM_Cantillana";
	private static final int TOKEN_VALIDITY = 3600 * 5; // 5 horas en segundos

	/**
	 * Obtiene el nombre de usuario almacenado en el token JWT.
	 * 
	 * @param token El token JWT del que se obtiene el nombre de usuario.
	 * @return El nombre de usuario extraído del token.
	 */
	public String getUsernameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}

	/**
	 * Obtiene una reclamación específica del token JWT utilizando un resolutor de
	 * reclamaciones.
	 * 
	 * @param token          El token JWT del que se obtiene la reclamación.
	 * @param claimsResolver El resolutor de reclamaciones que se utiliza para
	 *                       obtener la reclamación deseada.
	 * @return La reclamación obtenida del token.
	 */
	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}

	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
	}

	/**
	 * Valida si un token JWT es válido para un UserDetails específico.
	 * 
	 * @param token       El token JWT que se valida.
	 * @param userDetails Los detalles del usuario para los que se valida el token.
	 * @return true si el token es válido para los userDetails proporcionados, de lo
	 *         contrario false.
	 */
	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = getUsernameFromToken(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}

	/**
	 * Genera un nuevo token JWT para los UserDetails proporcionados.
	 * 
	 * @param userDetails Los UserDetails para los que se genera el token JWT.
	 * @return El token JWT generado.
	 */
	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();

		return Jwts.builder().setClaims(claims).setSubject(userDetails.getUsername())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + TOKEN_VALIDITY * 1000)) // Expiración en
																								// milisegundos
				.signWith(SignatureAlgorithm.HS512, SECRET_KEY).compact();
	}
}
