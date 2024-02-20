package com.com.everth.bankinc.sericeImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.com.everth.bankinc.entity.UsuariosEntity;
import com.com.everth.bankinc.repository.UsuariosRepository;
import com.com.everth.bankinc.service.UsuariosService;


@Service
public class UsuariosServiceImpl implements UsuariosService{

	
	@Autowired
	private UsuariosRepository usuariosRepository;
	
	@Override
	public UsuariosEntity loguearUsuario(UsuariosEntity usuario) throws Exception {
		
		
		
		UsuariosEntity usuarioExiste2 = usuariosRepository.findByEmail(usuario.getEmail());
		
	
		return usuarioExiste2;
		
	}
	
	@Override
	public UsuariosEntity findByUserEmail(UsuariosEntity usuario) throws Exception {
		
		UsuariosEntity user = usuariosRepository.findByEmail(usuario.getEmail());
		
		if (user != null) {
            // Verificar la contraseña (debe usar BCryptPasswordEncoder en una aplicación real)
            if (user.getContrasena().equals(usuario.getContrasena())) {
                return user;
            }
        }
        return null;
		
	}

}
