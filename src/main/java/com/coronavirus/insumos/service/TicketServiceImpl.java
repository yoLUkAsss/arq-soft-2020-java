package com.coronavirus.insumos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coronavirus.insumos.exceptions.TicketInvalidoException;
import com.coronavirus.insumos.modelo.Cancelado;
import com.coronavirus.insumos.modelo.Enviado;
import com.coronavirus.insumos.modelo.EstadoTicket;
import com.coronavirus.insumos.modelo.Insumo;
import com.coronavirus.insumos.modelo.Ticket;
import com.coronavirus.insumos.modelo.Usuario;
import com.coronavirus.insumos.repository.EstadoTicketRepository;
import com.coronavirus.insumos.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService{

	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired
	private EstadoTicketRepository estadoTicketRepository;
	
	@Override
	public Ticket crearTicket(Usuario usuario, Insumo insumo) {
		Ticket ticket = new Ticket(usuario, insumo);
		EstadoTicket enviado = new Enviado();
		this.estadoTicketRepository.save(enviado);
		ticket.setEstado(enviado);
		
		ticketRepository.save(ticket);
		
		return ticket;
	}

	@Override
	public List<Ticket> obtenerTicketByUsuario(Usuario usuario) {
		return ticketRepository.obtenerTicketByUsuario(usuario);
		
	}

	@Override
	public Optional<Ticket> getTicketById(Long id) {
		return ticketRepository.findById(id);
	}
	
	public void cancelarTicket(Long id) {
		Optional<Ticket> OptTicket = this.getTicketById(id);
		if (OptTicket.isPresent()) {
			Ticket ticket = OptTicket.get();
			EstadoTicket cancelado = new Cancelado();
			estadoTicketRepository.save(cancelado);
			ticket.setEstado(cancelado);
			ticketRepository.save(ticket);
		}else {
			throw new TicketInvalidoException("El ticket es inexistente");	
		}
	}

}
