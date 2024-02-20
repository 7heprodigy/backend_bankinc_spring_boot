/**
 * 
 */
package com.com.everth.bankinc.service;

import java.util.List;

import com.com.everth.bankinc.entity.DataTransaccionEntity;
import com.com.everth.bankinc.entity.Tarjeta;



/**
 * @ everth
 * @version 1.0 08/21/2023
 * Intreface que contiene los metodos de logica de negocio para las tarjetas.
 */
public interface TarjetasService {
	
	/**
	 * Metodo que permite generar una nueva tarjeta con saldo en 0 y en estado inactiva
	 * @return tarjeta.
	 * @throws Exception 
	 */
	Tarjeta generarNumTarjeta(Long idProducto) throws Exception;
	
	
	/**
	 * Metodo que permite activar el producto luego de su creación
	 * @return tarjeta.
	 * @throws Exception 
	 */
	Tarjeta activarProducto(Long idProducto) throws Exception;
	
	
	/**
	 * Metodo que permite bloquear el producto
	 * @return 
	 * @throws Exception 
	 * 
	 */
	Tarjeta bloquearProducto(Long idProducto) throws Exception;
	
	
	/**
	 * Metodo que permite carga saldo al producto
	 * @return tarjeta.
	 * @throws Exception 
	 */
	Tarjeta cargaSaldoProducto(Tarjeta productoTarjeta) throws Exception;
	
	
	/**
	 * Metodo que permite consultar el producto
	 * @return tarjeta.
	 * @throws Exception 
	 */
	Tarjeta consultarProducto(Long id) throws Exception;

	/**
	 * Metodo que permite consultar todos los productos
	 * @return tarjeta.
	 * @throws Exception 
	 */
	List<Tarjeta> consultarProductos() throws Exception;
	
	
	/**
	 * Metodo que permite eliminar todos los productos
	 * @return tarjeta.
	 * @throws Exception 
	 */
	List<Tarjeta> eliminarrProductos(Tarjeta productos) throws Exception;
	
	


}
