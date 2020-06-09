package com.coronavirus.insumos.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.coronavirus.insumos.baseClasses.BaseController;
import com.coronavirus.insumos.baseClasses.BaseService;
import com.coronavirus.insumos.employees.dto.EmployeeDto;

@Controller
@RequestMapping("/users")
public class EmployeeController extends BaseController<Employee, EmployeeDto> {
	
	@Autowired
	private EmployeeService employeeService;

	@Override
	public BaseService<Employee, EmployeeDto> getBaseService() {
		return this.employeeService;
	}

	@Override
	public EmployeeDto toDto(Employee entity) {
		EmployeeDto dto = new EmployeeDto();
		dto.setId(entity.getId());
		dto.setCargo(entity.getCargo());
		dto.setEmail(entity.getEmail());
		dto.setEntidad(entity.getEntidad());
		dto.setNombre(entity.getNombre());
		dto.setLocalidad(entity.getLocalidad());
		dto.setTelefono(entity.getTelefono());
		dto.setPassword(entity.getPassword());
		return dto;
	}

	@Override
	public Employee toEntity(EmployeeDto dto) {
		Employee entity = new Employee();
//		entity.setId(dto.getId());
		entity.setCargo(dto.getCargo());
		entity.setEmail(dto.getEmail());
		entity.setEntidad(dto.getEntidad());
		entity.setNombre(dto.getNombre());
		entity.setLocalidad(dto.getLocalidad());
		entity.setTelefono(dto.getTelefono());
		entity.setPassword(dto.getPassword());
		
		return entity;
	}

	@Override
	public void copyProperties(EmployeeDto dto, Employee entity) {
		entity.setCargo(dto.getCargo());
		entity.setEmail(dto.getEmail());
		entity.setEntidad(dto.getEntidad());
		entity.setNombre(dto.getNombre());
		entity.setLocalidad(dto.getLocalidad());
		entity.setTelefono(dto.getTelefono());
		entity.setPassword(dto.getPassword());
	}
}
