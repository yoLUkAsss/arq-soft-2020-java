package com.coronavirus.insumos.api;

import java.util.Optional;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coronavirus.insumos.dto.LoginRequest;
import com.coronavirus.insumos.dto.LoginResponse;
import com.coronavirus.insumos.modelo.Usuario;
import com.coronavirus.insumos.service.AuthService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;


@Service
public class InsumosApiImpl implements InsumosApi {
	
	@Autowired
	private AuthService authService;

	@Override
	public Response isAlive() {
		return Response.ok("its alive").build();
	}

	@Override
	public Response crearUsuario(Usuario usuario) {
		ObjectNode objectNode = new ObjectMapper().createObjectNode();
		try {
			authService.crearUsuario(usuario);
			return Response.ok(usuario).build();
		} catch (Exception e) {
			e.printStackTrace();
			objectNode.put("Error", e.getMessage());
			return Response.status(400).entity(objectNode.toString()).build();
		}
	}

	@Override
	public Response emailValido(String email) {
		Optional<Usuario> usuario = authService.usuarioByEmail(email);
		
		if(usuario.isPresent()) {
			return Response.status(400).entity("Error, el email ya se encuentra en uso").build();
		}else {
			return Response.ok().build();
		}
	}

	@Override
	public Response login(LoginRequest request) {
		ObjectNode objectNode = new ObjectMapper().createObjectNode();
		try {
			LoginResponse response = authService.login(request);
			return Response.ok(response).build();
		}catch(Exception e) {
			e.printStackTrace();
			objectNode.put("Error", e.getMessage());
			return Response.status(400).entity(objectNode.toString()).build();
		}
	}
	
	
	
	
	
}
