package com.coronavirus.insumos.modelo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.coronavirus.insumos.utils.MiLocalDateTimeSerializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@JsonIgnoreProperties(value = {"new" , "id"})
public class Aprobado extends EstadoTicket{
	@Column
	@JsonSerialize(using= MiLocalDateTimeSerializer.class)
	public LocalDateTime fechaAprobado = LocalDateTime.now();
	// AGREGAR El PROVEEDOR DERIVADO.
	
	public LocalDateTime getFechaAprobado() {
		return fechaAprobado;
	}

	public void setFechaAprobado(LocalDateTime fechaAprobado) {
		this.fechaAprobado = fechaAprobado;
	}
	


	
}
