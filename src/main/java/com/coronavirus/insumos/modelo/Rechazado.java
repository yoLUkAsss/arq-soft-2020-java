package com.coronavirus.insumos.modelo;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(value = {"new" , "id"})
public class Rechazado extends EstadoTicket{
	
	public Rechazado(){};
}
