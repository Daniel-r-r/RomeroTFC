package com.romero.ecommerce.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.romero.ecommerce.entity.ImageModel;
import com.romero.ecommerce.entity.Product;
import com.romero.ecommerce.service.ProductService;

/**
 * Controlador para manejar las operaciones relacionadas con los productos en la
 * aplicación de comercio electrónico.
 * 
 * @author Daniel Romero
 */
@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	/**
	 * Endpoint para agregar un nuevo producto.
	 * 
	 * @param product El producto a agregar.
	 * @return El producto agregado.
	 */
	@PreAuthorize("hasRole('Admin')")
	@PostMapping(value = { "/addNewProduct" }, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public Product addNewProduct(@RequestPart("product") Product product,
			@RequestPart("imageFile") MultipartFile[] file) {

		try {
			Set<ImageModel> images = uploadImage(file);
			product.setProductImages(images);
			return productService.addNewProduct(product);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	/**
	 * Sube las imágenes del producto y las convierte en un conjunto de objetos
	 * ImageModel.
	 * 
	 * @param multipartFiles Array de archivos MultipartFile que contienen las
	 *                       imágenes del producto.
	 * @return Un conjunto de objetos ImageModel que representan las imágenes del
	 *         producto.
	 * @throws IOException Si se produce un error al leer las imágenes.
	 */
	public Set<ImageModel> uploadImage(MultipartFile[] multipartFiles) throws IOException {
		Set<ImageModel> imageModels = new HashSet<>();

		for (MultipartFile file : multipartFiles) {
			ImageModel imageModel = new ImageModel(file.getOriginalFilename(), file.getContentType(), file.getBytes());

			imageModels.add(imageModel);
		}

		return imageModels;
	}

	/**
	 * Endpoint para obtener todos los productos.
	 * 
	 * @return Una lista de todos los productos.
	 */
	@GetMapping({"/getAllProducts"})
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}
	

	/**
	 * Método utilizado para eliminar elementos de la tabla por ID.
	 * 
	 * @param productId
	 */
	@DeleteMapping ({"/deleteProductDetails/{productId}"})
	public void deleteProductDetails(@PathVariable("productId") Integer productId) {
		productService.deleteProductDetails(productId);
	}
}
