/**
 * 
 */
package com.com.everth.bankinc.entity;

import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * @Everth
 * @version 1.0 08/21/2023
 * Clase que reprensenta la tabla transacciones.
 */
@Data
@Entity
@Table(name = "transacciones")
public class Transaccion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "id_transacciones")
	private Long idTransacciones; 
	
	@Column(name = "estado")
	private Boolean estado; 
	
	@Column(name = "hora")
	private Timestamp hora; 
	
	@Column(name = "precio")
	private Double precio;
	
	@Column(name = "id_producto")
	private Long idProducto;
	
	




	/**
	 * @return the idTransacciones
	 */
	public Long getIdTransacciones() {
		return idTransacciones;
	}


	/**
	 * @param idTransacciones the idTransacciones to set
	 */
	public void setIdTransacciones(Long idTransacciones) {
		this.idTransacciones = idTransacciones;
	}


	/**
	 * @return the estado
	 */
	public Boolean getEstado() {
		return estado;
	}


	/**
	 * @param estado the estado to set
	 */
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}


	/**
	 * @return the hora
	 */
	public Timestamp getHora() {
		return hora;
	}


	/**
	 * @param hora the hora to set
	 */
	public void setHora(Timestamp hora) {
		this.hora = hora;
	}


	/**
	 * @return the precio
	 */
	public Double getPrecio() {
		return precio;
	}


	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(Double precio) {
		this.precio = precio;
	}


	/**
	 * @return the idProducto
	 */
	public Long getIdProducto() {
		return idProducto;
	}


	/**
	 * @param idProducto the idProducto to set
	 */
	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}
	
	
}
