package com.coronavirus.insumos.modelo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.coronavirus.insumos.utils.MiLocalDateTimeSerializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@JsonIgnoreProperties(value = {"new" , "id"})
public class Rechazado extends EstadoTicket{

	@Column
	@JsonSerialize(using= MiLocalDateTimeSerializer.class)
	public LocalDateTime fechaRechazo = LocalDateTime.now();

	public LocalDateTime getFechaRechazo() {
		return fechaRechazo;
	}

	public void setFechaRechazo(LocalDateTime fechaRechazo) {
		this.fechaRechazo = fechaRechazo;
	}
	
	
}
