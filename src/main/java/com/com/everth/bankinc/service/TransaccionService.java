package com.com.everth.bankinc.service;

import com.com.everth.bankinc.entity.DataTransaccionAnularEntity;
import com.com.everth.bankinc.entity.DataTransaccionEntity;
import com.com.everth.bankinc.entity.Tarjeta;
import com.com.everth.bankinc.entity.Transaccion;


public interface TransaccionService {
	
	Transaccion guardarTransaccion(Transaccion transaccion);
	
	Transaccion crearTransaccion(DataTransaccionEntity transaccion) throws Exception;
	
	Transaccion consultarTransaccion(Long idTransaccion) throws Exception;
	
	Transaccion anularTransaccion(DataTransaccionAnularEntity transaccionAnular) throws Exception;


}
