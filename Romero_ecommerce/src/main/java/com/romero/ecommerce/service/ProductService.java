package com.romero.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.romero.ecommerce.dao.ProductDao;
import com.romero.ecommerce.entity.Product;

/**
 * Servicio para manejar las operaciones relacionadas con los productos en la
 * aplicación de comercio electrónico.
 * 
 * @author Daniel Romero
 */
@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;

	/**
	 * Agrega un nuevo producto a la base de datos.
	 * 
	 * @param product El producto a agregar.
	 * @return El producto agregado.
	 */
	public Product addNewProduct(Product product) {
		return productDao.save(product);
	}

	/**
	 * Obtiene todos los productos de la base de datos.
	 * 
	 * @return Una lista de todos los productos.
	 */
	public List<Product> getAllProducts() {
		return (List<Product>) productDao.findAll();
	}

	/**
	 * Recupera los detalles de un producto mediante su ID.
	 * 
	 * @param productId El ID del producto del cual se desean recuperar los
	 *                  detalles.
	 * @return El objeto Product que contiene los detalles del producto
	 *         correspondiente al ID proporcionado.
	 * 
	 */
	public Product getProductDetailsById(Integer productId) {
		return productDao.findById(productId).get();
	}

	/**
	 * Borrar elementos por Id.
	 * 
	 * @param productId
	 */
	public void deleteProductDetails(Integer productId) {
		productDao.deleteById(productId);
	}

	/**
	 * Obtiene los detalles de los productos según los parámetros proporcionados.
	 * 
	 * @param isSingleProductCheckout indica si se está realizando una compra de un
	 *                                solo producto
	 * @param productId               el ID del producto si se está realizando una
	 *                                compra de un solo producto
	 * @return una lista de detalles de productos
	 */
	public List<Product> getProductDetails(boolean isSingleProductCheckout, Integer productId) {
		if (isSingleProductCheckout && productId != 0) {
			// 1 unico objeto

			List<Product> list = new ArrayList<>();
			Product product = productDao.findById(productId).get();
			list.add(product);
			return list;
		} else {
			// ver carrito

		}
		return new ArrayList<>();
	}
}
