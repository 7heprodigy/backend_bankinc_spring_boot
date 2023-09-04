package com.com.everth.bankinc.repository;

import org.springframework.data.repository.CrudRepository;

import com.com.everth.bankinc.entity.Transaccion;

/**
 * @ everth
 * @version 1.0 08/29/2023
 * Interface que contiene el CRUD con jpa para la tabla Trasaccion.
 */
public interface TransaccionRepository extends CrudRepository<Transaccion, Long>{

}
 