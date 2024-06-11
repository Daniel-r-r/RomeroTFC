package com.romero.ecommerce.configuration;

import com.romero.ecommerce.service.JwtService;
import com.romero.ecommerce.util.JwtUtil;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Filtro para procesar las solicitudes JWT en la aplicación de comercio
 * electrónico. Este filtro valida y procesa el token JWT para la autenticación
 * de usuarios.
 * 
 * @author Daniel Romero
 */
@Component
public class JwtRequestFilter extends OncePerRequestFilter {
	
    public static String CURRENT_USER = "";

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private JwtService jwtService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		// Obtiene el token de la cabecera de la solicitud
		final String requestTokenHeader = request.getHeader("Authorization");

		String username = null;
		String jwtToken = null;

		// Verifica si el token es válido y comienza con "Bearer"
		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
			jwtToken = requestTokenHeader.substring(7);
			try {
				// Obtiene el nombre de usuario del token
				username = jwtUtil.getUsernameFromToken(jwtToken);
				CURRENT_USER = username;
			} catch (IllegalArgumentException e) {
				System.out.println("Unable to get JWT Token");
			} catch (ExpiredJwtException e) {
				System.out.println("JWT Token has expired");
			}
		} else {
			System.out.println("JWT token does not start with Bearer");
		}

		// Si el nombre de usuario es válido y no hay autenticación previa en el
		// contexto de seguridad
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

			// Carga los detalles del usuario utilizando el servicio JwtService
			UserDetails userDetails = jwtService.loadUserByUsername(username);

			// Si el token es válido, autentica al usuario
			if (jwtUtil.validateToken(jwtToken, userDetails)) {

				// Crea la autenticación del usuario y la establece en el contexto de seguridad
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}

		// Continúa con la cadena de filtros
		filterChain.doFilter(request, response);

	}

}
