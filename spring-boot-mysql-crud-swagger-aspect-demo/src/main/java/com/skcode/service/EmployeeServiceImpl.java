package com.skcode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skcode.entity.Employee;
import com.skcode.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	public Employee create(Employee employee) {
		return repository.save(employee);
	}

	public List<Employee> getAll() {
		return repository.findAll();
	}

	public Employee getById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public Employee update(Long id, Employee updated) {
		return repository.findById(id)
				.map(emp -> repository.save(new Employee(id, updated.getName(), updated.getRole()))).orElse(null);
	}

}
