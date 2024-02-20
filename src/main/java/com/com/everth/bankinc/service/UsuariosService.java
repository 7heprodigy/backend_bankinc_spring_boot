package com.com.everth.bankinc.service;

import com.com.everth.bankinc.entity.UsuariosEntity;

public interface UsuariosService {
	
	UsuariosEntity loguearUsuario(UsuariosEntity usuario) throws Exception;
	
	UsuariosEntity findByUserEmail(UsuariosEntity usuario) throws Exception;

}
