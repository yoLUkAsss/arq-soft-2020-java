package com.coronavirus.insumos.service;

import java.util.List;

import com.coronavirus.insumos.modelo.Insumo;
import com.coronavirus.insumos.modelo.Ticket;
import com.coronavirus.insumos.modelo.Usuario;

public interface TicketService {

	public Ticket crearTicket(Usuario usuario, Insumo insumo);
	
	public List<Ticket> obtenerTicketByUsuario(Usuario usuario);
}
