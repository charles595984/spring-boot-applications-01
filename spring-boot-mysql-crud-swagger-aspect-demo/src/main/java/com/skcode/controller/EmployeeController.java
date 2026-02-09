package com.skcode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skcode.entity.Employee;
import com.skcode.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
    
    @PostMapping("/create")
    public Employee create(@RequestBody Employee employee) {
        return service.create(employee);
    }

    @GetMapping("/getAll")
    public List<Employee> getAll() {
        return service.getAll();
    }

    @GetMapping("/getById/{id}")
    public Employee getById(@PathVariable Long id) {
        return service.getById(id);
    }
    
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/update/{id}")
    public Employee update(@PathVariable Long id, @RequestBody Employee employee) {
        return service.update(id, employee);
    }

    

}
