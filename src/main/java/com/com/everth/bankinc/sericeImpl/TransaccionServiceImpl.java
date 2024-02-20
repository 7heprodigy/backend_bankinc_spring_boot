package com.com.everth.bankinc.sericeImpl;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import org.apache.tomcat.util.bcel.Const;
import org.hibernate.annotations.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.com.everth.bankinc.entity.DataTransaccionAnularEntity;
import com.com.everth.bankinc.entity.DataTransaccionEntity;
import com.com.everth.bankinc.entity.Tarjeta;
import com.com.everth.bankinc.entity.Transaccion;
import com.com.everth.bankinc.repository.TarjetasRepository;
import com.com.everth.bankinc.repository.TransaccionRepository;
import com.com.everth.bankinc.service.TransaccionService;

@Service
public class TransaccionServiceImpl implements TransaccionService{

	
	@Autowired
	private TransaccionRepository transaccionRepository;
	
	@Autowired
	private TarjetasRepository tarjetasRepository;
	
	
	@Override
	public Transaccion guardarTransaccion(Transaccion transaccion) {	
		return this.transaccionRepository.save(transaccion);
	}

	@Override
	public Transaccion crearTransaccion(DataTransaccionEntity transaccion) throws Exception {
		Transaccion nuevaTransaccion = new Transaccion();
		Optional<Tarjeta> producto2 =  tarjetasRepository.findById(transaccion.getCardId());
		
		if(producto2.isPresent() && producto2.get().getBalance() > transaccion.getPrice()){
			
			nuevaTransaccion.setEstado(true);
			nuevaTransaccion.setIdProducto(transaccion.getCardId());
			Long fechaLong = System.currentTimeMillis();
			Timestamp fechaActual = new Timestamp(fechaLong);
			nuevaTransaccion.setHora(fechaActual);
			nuevaTransaccion.setPrecio(transaccion.getPrice()); 
			Double saldoDisponible = producto2.get().getBalance() - transaccion.getPrice();
			producto2.get().setBalance(saldoDisponible);
			tarjetasRepository.save(producto2.get());
			nuevaTransaccion = transaccionRepository.save(nuevaTransaccion);
			return nuevaTransaccion;
		}
		throw new Exception(", El Valor de la compra: " + transaccion.getPrice() + " Saldo en la cuenta: " + producto2.get().getBalance() + " FONDOS SICUFICIENTES!!" );
	}

	
	@Override
	public Transaccion consultarTransaccion(Long idTransaccion) throws Exception {
	
		Optional<Transaccion> transaccionEncontrada =  transaccionRepository.findById(idTransaccion);
		System.out.println(idTransaccion);
		System.out.println(transaccionEncontrada);
		
		if(transaccionEncontrada.isPresent()) {
			return transaccionEncontrada.get();
		}
		throw new Exception("EL NUMERO DE LA TRANSACCION NO SE ENCUENTRA REGISTRADA");	
	}

	
	
	@Override
	public Transaccion anularTransaccion(DataTransaccionAnularEntity transaccionAnular) throws Exception {
		
		Optional<Transaccion> transaccionEncontrada = transaccionRepository.findById(transaccionAnular.getTransactionId());
		System.out.println("QUE ENCONTRE???------" + transaccionEncontrada);
		
		if(transaccionEncontrada.isPresent()) {
			
			transaccionEncontrada.get().setEstado(false);
			transaccionRepository.save(transaccionEncontrada.get());
			Optional<Tarjeta> producto =  tarjetasRepository.findById(transaccionAnular.getCardId());
			
			Timestamp fechaActual = new Timestamp(System.currentTimeMillis());
			LocalDateTime tiempoTransaccion = transaccionEncontrada.get().getHora().toLocalDateTime();
			LocalDateTime tiempoActualTranscurrido = fechaActual.toLocalDateTime();
			int minutes = (int) ChronoUnit.MINUTES.between(tiempoTransaccion, tiempoActualTranscurrido);
			
			if(minutes < (60 * 24) && transaccionEncontrada.get().getEstado()){
				
				if(producto.isPresent()) {
					Double saldoDisponible = producto.get().getBalance() + transaccionEncontrada.get().getPrecio();
					producto.get().setBalance(saldoDisponible);
					tarjetasRepository.save(producto.get());
				}
			}
			return transaccionEncontrada.get();
		}
		 throw new Exception("EL NUMERO DE LA TRANSACCION NO SE ENCUENTRA REGISTRADA O NO PUDO SER ANULADA");	
	}

}
