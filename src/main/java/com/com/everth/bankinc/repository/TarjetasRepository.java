package com.com.everth.bankinc.repository;

import org.springframework.data.repository.CrudRepository;
import com.com.everth.bankinc.entity.Tarjeta;
import java.util.List;



/**
 * @ everth
 * @version 1.0 08/21/2023
 * Interface que contiene el CRUD con jpa para la tabla Tarjeta.
 */
public interface TarjetasRepository extends CrudRepository<Tarjeta, Long>{
	
	List<Tarjeta> findByNombre(String nombre);
	List<Tarjeta> findAll();


}
