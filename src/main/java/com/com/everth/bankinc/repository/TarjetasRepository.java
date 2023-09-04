package com.com.everth.bankinc.repository;

import org.springframework.data.repository.CrudRepository;
import com.com.everth.bankinc.entity.Tarjeta;


/**
 * @ everth
 * @version 1.0 08/21/2023
 * Interface que contiene el CRUD con jpa para la tabla Tarjeta.
 */
public interface TarjetasRepository extends CrudRepository<Tarjeta, Long>{


}
