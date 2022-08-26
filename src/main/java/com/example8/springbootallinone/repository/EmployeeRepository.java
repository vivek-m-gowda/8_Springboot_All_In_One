package com.example8.springbootallinone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.example8.springbootallinone.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query(value = "SELECT * FROM tbl_employee WHERE name=?1", nativeQuery = true)
	public List<Employee> getByName(String name);
	
	@Query(value = "SELECT * FROM tbl_employee WHERE department=?1", nativeQuery = true)
	public List<Employee> getByDepartment(String department);
	
}
