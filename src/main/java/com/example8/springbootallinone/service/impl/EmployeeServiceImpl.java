package com.example8.springbootallinone.service.impl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example8.springbootallinone.model.Employee;
import com.example8.springbootallinone.repository.EmployeeRepository;
import com.example8.springbootallinone.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
	
	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee getSingleEmployee(Long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee.isPresent()) {
			return employee.get();
		}
		throw new RuntimeException("Employee is not found for the id " +id);
	}

	@Override
	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
		
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
}