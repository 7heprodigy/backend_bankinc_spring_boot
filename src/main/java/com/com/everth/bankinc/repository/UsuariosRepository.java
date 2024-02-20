package com.com.everth.bankinc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.com.everth.bankinc.entity.UsuariosEntity;


public interface UsuariosRepository extends JpaRepository<UsuariosEntity, Long>{
	
	public UsuariosEntity findByEmail(String email);
	
}
