package com.coronavirus.insumos.employees.dto;

import com.coronavirus.insumos.baseClasses.BaseDTO;
import com.coronavirus.insumos.employees.Employee;

public class EmployeeDto extends BaseDTO<Employee>{
	
	private Long id;
	private String nombre;
	private String email;
	private String telefono;
	private String entidad;
	private String cargo;
	private String localidad;
	private String password;
	
	public EmployeeDto() {}

	
	@Override
	public Long getId() {
		return this.id;
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
