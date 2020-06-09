package com.coronavirus.insumos.employees;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;


@Entity
@Table(name = "empleado")
public class Employee {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NonNull
	private String nombre;
	
	@NonNull
	@Column(unique = true)
	private String email;
	
	@NonNull
	private String telefono;
	
	@NonNull
	private String entidad;
	
	@NonNull
	private String cargo;
	
	@NonNull
	private String localidad;
	
	@NonNull
	private String password;
	
	public Employee() {}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEntidad() {
		return entidad;
	}

	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
