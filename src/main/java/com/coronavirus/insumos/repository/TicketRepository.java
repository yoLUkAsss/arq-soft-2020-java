package com.coronavirus.insumos.repository;

import org.springframework.data.repository.CrudRepository;

import com.coronavirus.insumos.modelo.Ticket;

public interface TicketRepository extends CrudRepository<Ticket, Long>{

}
