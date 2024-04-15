package com.romero.ecommerce.controller;


import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.romero.ecommerce.entity.ImageModel;
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
	@PostMapping (value = {"/addNewProduct"}, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public Product addNewProduct(@RequestPart("product") Product product,
								 @RequestPart("imageFile")MultipartFile[]file) {

		try {
			Set <ImageModel> images = uploadImage(file);
			product.setProductImages(images);
			return productService.addNewProduct(product);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public Set<ImageModel> uploadImage(MultipartFile[] multipartFiles) throws IOException {
		Set<ImageModel> imageModels = new HashSet<>();
		
		for (MultipartFile file: multipartFiles) {
			ImageModel imageModel = new ImageModel(
					file.getOriginalFilename(),
					file.getContentType(),
					file.getBytes()		
			);
			
			imageModels.add(imageModel);
		}
		
		return imageModels;
	}
}
