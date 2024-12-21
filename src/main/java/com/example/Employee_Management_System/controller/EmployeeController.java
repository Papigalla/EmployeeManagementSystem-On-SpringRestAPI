package com.example.Employee_Management_System.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Employee_Management_System.entity.Employee;
import com.example.Employee_Management_System.service.EmployeeService;
import com.example.Employee_Management_System.util.ResponseStructure;

@RestController
public class EmployeeController {
	private final EmployeeService service;

	public EmployeeController(EmployeeService service) {
		super();
		this.service = service;
	}
	@PostMapping("/add-employee")
	public ResponseEntity<ResponseStructure<Employee>> add(@RequestBody Employee employee)
	{
		employee=service.addEmployee(employee);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(ResponseStructure.create(HttpStatus.CREATED.value(),"Employee is successfully added",employee));
	}
	@GetMapping("/find-employee")
	public ResponseEntity<ResponseStructure<Employee>> display(@RequestParam("employee_id") int employeeId)
	{
	Employee employee=service.findEmployee(employeeId);
		return ResponseEntity.status(HttpStatus.FOUND)
				.body(ResponseStructure.create(HttpStatus.FOUND.value(),"Employee is successfully found",employee));
	}
	@DeleteMapping("/delete-employee")
	public ResponseEntity<ResponseStructure<Employee>> delete(@RequestParam("employee_id") int employeeId)
	{
	Employee employee=service.deleteEmployee(employeeId);
		return ResponseEntity.status(HttpStatus.OK)
				.body(ResponseStructure.create(HttpStatus.OK.value(),"Employee is successfully Delete",employee));
	}
	@PutMapping("/update-employee")
	public ResponseEntity<ResponseStructure<Employee>> update(@RequestBody Employee employee)
	{
	 employee=service.updateEmployee(employee);
		return ResponseEntity.status(HttpStatus.OK)
				.body(ResponseStructure.create(HttpStatus.OK.value(),"Employee is successfully updated",employee));
	}
	
	

}
