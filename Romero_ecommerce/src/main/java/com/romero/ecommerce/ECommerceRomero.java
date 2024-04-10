package com.romero.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal para la aplicación de comercio electrónico.
 * Esta clase inicializa la aplicación Spring Boot.
 *
 * @author Daniel Romero
 */
@SpringBootApplication
public class ECommerceRomero {

    /**
     * Método principal para iniciar la aplicación de comercio electrónico.
     * @param args Argumentos de línea de comandos pasados a la aplicación.
     */
    public static void main(String[] args) {
        SpringApplication.run(ECommerceRomero.class, args);
    }

}
