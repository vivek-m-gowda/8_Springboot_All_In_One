package com.example8.springbootallinone.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name="tbl_employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@NotBlank(message = "Name field should not be null")
	@Column(name = "name")
	private String name;
	
	@Min(18)
	@Max(60)
	@NotNull(message = "Age field should not be null")
	@Column(name = "age")
	private Long age;
	
	@NotBlank(message = "Location field should not be null")
	@Size(max = 30)
	@Column(name = "location")
	private String location;
	
	@NotBlank
	@Email(message = "Invalid email address")
	@Column(name = "email")
	private String email;
	
	@NotBlank(message = "Department field should not be null")
	@Column(name = "department")
	private String department;
	
	@CreationTimestamp
	@Column(name = "created_at", nullable = false, updatable = false)
	private Date createdAt;
	
	@UpdateTimestamp
	@Column(name = "updated_at")
	private  Date updatedAt;

}
