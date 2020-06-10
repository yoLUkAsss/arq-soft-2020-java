package com.coronavirus.insumos.api;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.coronavirus.insumos.dto.LoginRequest;
import com.coronavirus.insumos.modelo.Usuario;

@Path("insumos")
public interface InsumosApi {

	@GET
	@Path("/isAlive")
	Response isAlive();
	
	@POST
	@Path("/auth/registro")
	@Produces(MediaType.APPLICATION_JSON)
	Response crearUsuario(Usuario usuario);
	
	@GET
	@Path("/auth/validarEmail")
	@Produces(MediaType.APPLICATION_JSON)
	Response emailValido(@QueryParam("email") String email);
	
	@POST
	@Path("/auth/login")
	@Produces(MediaType.APPLICATION_JSON)
	Response login(LoginRequest request);
}
