/**
 * 
 */
package com.com.everth.bankinc.entity;

import java.util.Date;
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
 * Clase que reprensenta la tabla tarjetas.
 */

@Entity
@Data
@Table(name = "tarjetas")
public class Tarjeta {

	@Id
	@Column(name = "id_producto")
	private Long idProducto;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellido")
	private String apellido;
	
	@Column(name = "fecha_vencimiento")
	private Date fechaVencimiento;
	
	@Column(name = "balance")
	private Double balance;
	
	@Column(name = "activa")
	private Boolean activa;
	


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

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return the fechaVencimiento
	 */
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	/**
	 * @param fechaVencimiento the fechaVencimiento to set
	 */
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	/**
	 * @return the balance
	 */
	public Double getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(Double balance) {
		this.balance = balance;
	}

	/**
	 * @return the activa
	 */
	public Boolean getActiva() {
		return activa;
	}

	/**
	 * @param activa the activa to set
	 */
	public void setActiva(Boolean activa) {
		this.activa = activa;
	}

	@Override
	public String toString() {
		return "Tarjeta [idProducto=" + idProducto + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", fechaVencimiento=" + fechaVencimiento + ", balance=" + balance + ", activa=" + activa
				+ ", getIdProducto()=" + getIdProducto() + ", getNombre()=" + getNombre() + ", getApellido()="
				+ getApellido() + ", getFechaVencimiento()=" + getFechaVencimiento() + ", getBalance()=" + getBalance()
				+ ", getActiva()=" + getActiva() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}


	
	
}
