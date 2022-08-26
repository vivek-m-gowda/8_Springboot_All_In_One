package com.example8.springbootallinone.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example8.springbootallinone.model.Employee;
import com.example8.springbootallinone.repository.EmployeeRepository;
import com.example8.springbootallinone.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping("/AllEmployees")
	public ResponseEntity<List <Employee>> getEmpoyeees() {
		return new ResponseEntity<List<Employee>> (employeeService.getAllEmployees(), HttpStatus.OK) ;
	}
	
	@GetMapping("/EmployeeById/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Long id ) {
		return new ResponseEntity<Employee>(employeeService.getSingleEmployee(id), HttpStatus.OK);
	}
	
	@PostMapping("/SaveEmployee")
	public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee) {
		return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED );
	}
	
	@PutMapping("/UpdateEmployee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
		employee.setId(id);
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee), HttpStatus.OK);
	}
	
	@DeleteMapping("/DeleteById/{id}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("id")Long id ) {
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
	
	//native query to get by name
	@GetMapping("/GetByName/{name}")
	public List<Employee> getByName (@PathVariable String name){
		return employeeRepository.getByName(name);
	}
	
	//native query to get by department
	@GetMapping("/GetByDepartment/{department}")
	public List<Employee> getByDepartment(@PathVariable String department){
		return employeeRepository.getByDepartment(department);
	}
	
}
