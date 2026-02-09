package com.skcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skcode.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

