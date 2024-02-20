package com.com.everth.bankinc.sericeImpl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.com.everth.bankinc.entity.DataTransaccionEntity;
import com.com.everth.bankinc.entity.Tarjeta;
import com.com.everth.bankinc.entity.Transaccion;
import com.com.everth.bankinc.repository.TarjetasRepository;
import com.com.everth.bankinc.service.TarjetasService;





/**
 * @ 7heprodigy
 * @version 1.0 08/21/2023
 * Clase que implementa los metodos de logica del negocio de la interface de Tarjetas.
 */

@Service
public class TarjetasServiceImpl implements TarjetasService {

	
	@Autowired
	private TarjetasRepository tarjetasRepository;
	
	@Override
	public Tarjeta generarNumTarjeta(Long idProducto)throws Exception {
		
		Tarjeta nuevaTarjeta = new Tarjeta();		
		Long valorDado2 = (long) (10000 + Math.random() * 999999999);
		String concatenar = String.valueOf(idProducto) + String.valueOf(valorDado2);
		long idProductNew = Long.parseLong(concatenar);
	
		nuevaTarjeta.setIdProducto(idProductNew);
		nuevaTarjeta.setNombre("a");
		nuevaTarjeta.setApellido("b");
		nuevaTarjeta.setActiva(false);
		nuevaTarjeta.setBalance(0.0);
		
        Date fecha = new Date();
        Calendar calendario= new GregorianCalendar();
        calendario.setTime(fecha);
        calendario.add(Calendar.DATE,1095);        
        nuevaTarjeta.setFechaVencimiento(calendario.getTime());
        
        return this.tarjetasRepository.save(nuevaTarjeta);
		
	}
	
	
	@Override
	public Tarjeta activarProducto(Long idProducto)throws Exception {
		
		Optional<Tarjeta> tarjetaPorActivar = this.tarjetasRepository.findById(idProducto);
		if(tarjetaPorActivar.isPresent()){
			tarjetaPorActivar.get().setActiva(true);
			return this.tarjetasRepository.save(tarjetaPorActivar.get());
		}
		throw new Exception("El producto no fue encontrado dentro de los registros");
	}


	@Override
	public Tarjeta bloquearProducto(Long idProducto)throws Exception {
		
		Optional<Tarjeta> productoBloqueado = this.tarjetasRepository.findById(idProducto);
		if(productoBloqueado.isPresent()) {
			productoBloqueado.get().setActiva(false);
			this.tarjetasRepository.save(productoBloqueado.get());
			return productoBloqueado.get();
		}
		throw new Exception(" la tarjeta no pudo ser encontrada");
	}
	

	@Override
	public Tarjeta cargaSaldoProducto(Tarjeta productoTarjeta) throws Exception {
		
		Optional<Tarjeta> productoTarExiste = this.tarjetasRepository.findById(productoTarjeta.getIdProducto());
		if(!productoTarExiste.isEmpty() && productoTarExiste.get().getActiva()){
			productoTarExiste.get().setBalance(productoTarExiste.get().getBalance() + productoTarjeta.getBalance());
		}else {
			throw new Exception("la tarjeta no esta activada o se encuentra bloqueada");
		}
		return this.tarjetasRepository.save(productoTarExiste.get());
	}
	
	
	@Override
	public Tarjeta consultarProducto(Long id)throws Exception {		
		Optional<Tarjeta> producto =  this.tarjetasRepository.findById(id);
		if(producto.isPresent()){
			return producto.get();
		}
		throw new Exception(" El producto no pudo ser encontrado");
	}


	@Override
	public List<Tarjeta> consultarProductos() throws Exception {
		List<Tarjeta> productos = this.tarjetasRepository.findAll();
		return productos;
	}


	@Override
	public List<Tarjeta> eliminarrProductos(Tarjeta productos) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



}
