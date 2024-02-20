package com.com.everth.bankinc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "usuarios")
public class UsuariosEntity {
	
	
	@Id 
	@Column(name = "id_usuario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;
	
	
	@Column(name = "email_usuario")
	private String email;
	@Column(name = "contrasena_usuario")
	private String contrasena;
	
	
	

	/**
	 * @return the idUsuarios
	 */
	public Long getIdUsuarios() {
		return idUsuario;
	}

	/**
	 * @param idUsuarios the idUsuarios to set
	 */
	public void setIdUsuarios(Long idUsuarios) {
		this.idUsuario = idUsuarios;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the contrasena
	 */
	public String getContrasena() {
		return contrasena;
	}

	/**
	 * @param contrasena the contrasena to set
	 */
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	@Override
	public String toString() {
		return "UsuariosEntity [idUsuarios=" + idUsuario + ", email=" + email + ", contrasena=" + contrasena
				+ ", getIdUsuarios()=" + getIdUsuarios() + ", getEmail()=" + getEmail() + ", getContrasena()="
				+ getContrasena() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	
	
}
