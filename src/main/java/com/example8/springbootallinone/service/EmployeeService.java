package com.example8.springbootallinone.service;

import java.util.List;

import com.example8.springbootallinone.model.Employee;

public interface EmployeeService {
	
	Employee saveEmployee (Employee employee);	//Save employee
	
	List<Employee> getAllEmployees();	//Fetch all employees
	
	Employee getSingleEmployee (Long id);	//Fetch employee ById
	
	void deleteEmployee (Long id);	//Delete employee ById
	
	Employee updateEmployee (Employee employee); //Update employee 
	
}