package com.coronavirus.insumos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.coronavirus.insumos.modelo.Usuario;
import com.coronavirus.insumos.repository.UsuarioRepository;


@Component
public class StartUp implements ApplicationRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		// TODO AGREGAR ADMIN AUTOMATICAMENTE
		Usuario admin = new Usuario();
		admin.setEmail("admin@insumos.com.ar");
		admin.setPassword("admin123");
		admin.setRole("ROLE_ADMIN");
		usuarioRepository.save(admin);
		
	}

}