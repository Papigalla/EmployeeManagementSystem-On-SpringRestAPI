package com.example.Employee_Management_System.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.Employee_Management_System.entity.Employee;
import com.example.Employee_Management_System.exception.EmployeeNotFoundById;
import com.example.Employee_Management_System.repository.EmployeeRepository;

@Service
public class EmployeeService {
	private final EmployeeRepository repository;

	public EmployeeService(EmployeeRepository repository) {
		super();
		this.repository = repository;
	}

	public Employee addEmployee(Employee employee) {
		return repository.save(employee);
	}

	public Employee findEmployee(int employeeId) {
	return repository.findById(employeeId).orElseThrow(()->new EmployeeNotFoundById("employee is not there with this id"));
	}

	public Employee deleteEmployee(int employeeId) {
	Optional<Employee> optional=	repository.findById(employeeId);
	if(optional.isPresent())
	{
		Employee employee=optional.get();
		repository.delete(employee);
		return employee;
	}
	else
	{
		throw new EmployeeNotFoundById("employee is not there");
	}
	}

	public Employee updateEmployee(Employee employee) {
	Optional<Employee> optional=repository.findById(employee.getEmployeeId());
	if(optional.isPresent())
	{
	 return	repository.save(employee);
	}
	else
	{
		throw new EmployeeNotFoundById("Employee is not updated");
	}
	}

	

	

}
