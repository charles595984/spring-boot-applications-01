package com.skcode.service;

import java.util.List;

import com.skcode.entity.Employee;

public interface EmployeeService {

	public Employee create(Employee employee);
	
	public List<Employee> getAll();
	
	public Employee getById(Long id);
	
	public void delete(Long id);
	
	public Employee update(Long id, Employee updated);
	
}
