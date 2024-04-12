package com.romero.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romero.ecommerce.dao.ProductDao;
import com.romero.ecommerce.entity.Product;

/**
 * Servicio para manejar las operaciones relacionadas con los productos en la aplicación de comercio electrónico.
 * @author Daniel Romero
 */
@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;

	/**
	 * Agrega un nuevo producto a la base de datos.
	 * @param product El producto a agregar.
	 * @return El producto agregado.
	 */
	public Product addNewProduct(Product product) {
		return productDao.save(product);
	}
}
