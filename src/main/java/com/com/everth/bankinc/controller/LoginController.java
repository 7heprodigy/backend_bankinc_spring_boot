package com.com.everth.bankinc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.com.everth.bankinc.entity.UsuariosEntity;
import com.com.everth.bankinc.service.UsuariosService;


@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private UsuariosService usuariosServiceImpl;


	@PostMapping
	@RequestMapping(value = "cargar", method =RequestMethod.POST) 
	public ResponseEntity<?> cargar(@RequestBody(required = false) UsuariosEntity usuario) throws Exception {
		UsuariosEntity usuarioLogueado = null;
		System.out.println(usuarioLogueado.getEmail());
		usuarioLogueado = this.usuariosServiceImpl.findByUserEmail(usuario);
		
		if(usuarioLogueado != null) {
			return ResponseEntity.ok("Inicio de sesión exitoso");
		}else {
			 return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Inicio de sesión fallido");
		}
		
	}
	
	
	
}
