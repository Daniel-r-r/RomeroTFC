package com.romero.ecommerce.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.romero.ecommerce.entity.Product;

/**
 * Repositorio para acceder a la base de datos de productos en la aplicación de comercio electrónico.
 * Permite realizar operaciones CRUD en la tabla de productos.
 * @author Daniel Romero
 */
@Repository
public interface ProductDao extends CrudRepository <Product, Integer> {

}
