package com.coronavirus.insumos.employees;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coronavirus.insumos.baseClasses.BaseRepository;
import com.coronavirus.insumos.baseClasses.BaseService;
import com.coronavirus.insumos.employees.dto.EmployeeDto;

@Transactional
@Service
public class EmployeeService extends BaseService<Employee, EmployeeDto> {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public BaseRepository<Employee> getBaseRepository() {
		return this.employeeRepository;
	}

}
