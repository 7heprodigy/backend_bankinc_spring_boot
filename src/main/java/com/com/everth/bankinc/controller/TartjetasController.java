package com.com.everth.bankinc.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.com.everth.bankinc.entity.DataTransaccionEntity;
import com.com.everth.bankinc.entity.Tarjeta;
import com.com.everth.bankinc.entity.Transaccion;
import com.com.everth.bankinc.service.TarjetasService;
import com.com.everth.bankinc.service.TransaccionService;




@RestController
@RequestMapping("/card")
public class TartjetasController {
	
	
	@Autowired
	private TarjetasService tarjetasRepositoryImpl;

	 /**
	  * Metodo de genera una nueva tarjet con un numero asignado
	  * @param productId
	  * @return tarjeta
	  */
	@GetMapping
	@RequestMapping(value = "{productId}", method =RequestMethod.GET) 
	public Tarjeta generarTarjeta(@PathVariable Long productId ) {
		Tarjeta tarjetaGenerada;
		try {
			tarjetaGenerada = this.tarjetasRepositoryImpl.generarNumTarjeta(productId);
			return tarjetaGenerada;
		} catch (Exception e) {
			System.out.println("Error no se pudo generar la tarjeta: " + e.getMessage());
			return null;
		}
	}
	
	
	@PostMapping
	@RequestMapping(value = "enroll", method =RequestMethod.POST) 
	public ResponseEntity<?> activarProducto(@RequestBody(required=false) Tarjeta tarjeta) {
		Tarjeta tarjetaActivada = null;
		try {
			tarjetaActivada = this.tarjetasRepositoryImpl.activarProducto(tarjeta.getIdProducto());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error al intentar activar el producto: ");
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(tarjetaActivada);
	}
	
	
	@DeleteMapping
	@RequestMapping(value = "{cardId}", method =RequestMethod.DELETE) 
	public ResponseEntity<?> bloquearTarjeta(@PathVariable Long cardId) {
		try {
			this.tarjetasRepositoryImpl.bloquearProducto(cardId);
		} catch (Exception e) {
			System.out.println("Error al intentar bloquear el producto: ");
		}
		return ResponseEntity.ok().build();
	}
	
	@PostMapping
	@RequestMapping(value = "balance", method =RequestMethod.POST) 
	public ResponseEntity<?> cargarSaldo(@RequestBody(required=false) Tarjeta productoTarjeta) {
		Tarjeta productoCargado = null;
		try {
			productoCargado = this.tarjetasRepositoryImpl.cargaSaldoProducto(productoTarjeta);
		} catch (Exception e) {
			System.out.println("Error a intentar cargar saldo, " + e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(productoCargado);
	}
	
	@GetMapping
	@RequestMapping(value = "balance/{cardId}", method = RequestMethod.GET)
	public ResponseEntity<?> consultarProducto(@PathVariable Long cardId){
		Tarjeta producto = null;
		try {
			producto = this.tarjetasRepositoryImpl.consultarProducto(cardId);
		} catch (Exception e) {
			System.out.println("Error al intentar consultar el producto: " + e.getMessage());
		}	
		return ResponseEntity.status(HttpStatus.CREATED).body(producto);
	}
	
}
