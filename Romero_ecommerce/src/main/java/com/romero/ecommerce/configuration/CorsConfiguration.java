package com.romero.ecommerce.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Clase de configuración para la gestión de CORS (Cross-Origin Resource
 * Sharing) en la aplicación de comercio electrónico. Esta configuración permite
 * el acceso a recursos desde dominios externos.
 *
 * @author Daniel Romero
 */
@Configuration
public class CorsConfiguration {

	private static final String GET = "GET";
	private static final String POST = "POST";
	private static final String PUT = "PUT";
	private static final String DELETE = "DELETE";

	/**
	 * Configura el manejo de CORS en la aplicación.
	 * 
	 * @return Un WebMvcConfigurer que permite la configuración de CORS.
	 */
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedMethods(GET, POST, PUT, DELETE).allowedHeaders("*")
						.allowedOriginPatterns("*").allowCredentials(true);
			}
		};
	}
}
