package com.romero.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.romero.ecommerce.entity.Product;
import com.romero.ecommerce.service.ProductService;

/**
 * Controlador para manejar las operaciones relacionadas con los productos en la aplicación de comercio electrónico.
 * @author Daniel Romero
 */
@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;

	/**
	 * Endpoint para agregar un nuevo producto.
	 * @param product El producto a agregar.
	 * @return El producto agregado.
	 */
	@PostMapping ({"/addNewProduct"})
	public Product addNewProduct(@RequestBody Product product) {
		return productService.addNewProduct(product);
	}
}
