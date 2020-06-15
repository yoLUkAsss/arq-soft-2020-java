package com.coronavirus.insumos.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@Entity
@JsonIgnoreProperties(value = {"new", "id"})
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
		@Type(value = Enviado.class, name= "Enviado"),
		@Type(value = Cancelado.class, name= "Cancelado"),
		@Type(value = Aprobado.class, name= "Aprobado"),
		@Type(value = Rechazado.class, name= "Rechazado"),
		}
)
public class Medicamento extends Insumo {

	@Column
	public String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Medicamento(){};
}
