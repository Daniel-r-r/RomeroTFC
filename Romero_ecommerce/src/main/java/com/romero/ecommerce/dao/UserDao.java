package com.romero.ecommerce.dao;

import com.romero.ecommerce.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaz DAO para realizar operaciones CRUD en la entidad User en la
 * aplicación de comercio electrónico.
 * 
 * @author Daniel Romero
 */
@Repository
public interface UserDao extends CrudRepository<User, String> {
}
