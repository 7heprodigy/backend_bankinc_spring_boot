package com.com.everth.bankinc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.com.everth.bankinc.entity.DataTransaccionAnularEntity;
import com.com.everth.bankinc.entity.DataTransaccionEntity;
import com.com.everth.bankinc.entity.Transaccion;
import com.com.everth.bankinc.repository.TarjetasRepository;
import com.com.everth.bankinc.repository.TransaccionRepository;
import com.com.everth.bankinc.service.TransaccionService;



@RestController
@RequestMapping("/transaction")
public class TransaccionesController {
	
	
	@Autowired
	private TransaccionService transaccionesSericeImpl;
	
	@Autowired
	private TarjetasRepository tarjetaRepository;
	
	@GetMapping
	@RequestMapping(value = "purchase", method = RequestMethod.POST)
	public ResponseEntity<?> transanccionCompra(@RequestBody(required=false) DataTransaccionEntity productoTransaccion){
		Transaccion productoServicio = null;
		try {
			productoServicio = this.transaccionesSericeImpl.crearTransaccion(productoTransaccion);
		} catch (Exception e) {
			System.out.println("ERROR: Verifique que el valor de su compra no supere el saldo disponible en su tarjeta"+ e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(productoServicio);
	}
	
	
	@GetMapping
	@RequestMapping(value = "{transactionId}", method = RequestMethod.GET)
	public ResponseEntity<?> consultarTransaccition(@PathVariable Long transactionId){
		Transaccion productoServicio = null;
		try {
			productoServicio = this.transaccionesSericeImpl.consultarTransaccion(transactionId);
		} catch (Exception e) {
			
			System.out.println("ERROR al consultar la transaccion:  " + e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(productoServicio);
	}
	
	@PostMapping
	@RequestMapping(value = "anulation", method = RequestMethod.POST)
	public ResponseEntity<?> transanccionCompra(@RequestBody(required=true) DataTransaccionAnularEntity productoTransaccionAnular){
		Transaccion productoServicio = null;
		try {
			productoServicio = this.transaccionesSericeImpl.anularTransaccion(productoTransaccionAnular);
		} catch (Exception e) {
			System.out.println("ERROR: La transaccion no pudo ser anulada "+ e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(productoServicio);
	}
	

}
