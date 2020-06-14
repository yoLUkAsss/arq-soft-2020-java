package com.coronavirus.insumos.modelo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.coronavirus.insumos.utils.MiLocalDateTimeSerializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@JsonIgnoreProperties(value = {"new" , "id"})
public class Cancelado extends EstadoTicket{

	@Column
	@JsonSerialize(using= MiLocalDateTimeSerializer.class)
	public LocalDateTime fechaCancelado = LocalDateTime.now();

	public LocalDateTime getFechaCancelado() {
		return fechaCancelado;
	}

	public void setFechaCancelado(LocalDateTime fechaCancelado) {
		this.fechaCancelado = fechaCancelado;
	}
	
	
}
