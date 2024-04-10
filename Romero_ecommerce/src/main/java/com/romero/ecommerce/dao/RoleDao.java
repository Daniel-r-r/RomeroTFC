package com.romero.ecommerce.dao;

import com.romero.ecommerce.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaz DAO para realizar operaciones CRUD en la entidad Role en la base de
 * datos.
 * 
 * @author Daniel Romero
 */
@Repository
public interface RoleDao extends CrudRepository<Role, String> {

}
