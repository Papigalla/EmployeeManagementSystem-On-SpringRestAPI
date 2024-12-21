package com.example.Employee_Management_System.exception;

public class EmployeeNotFoundById extends RuntimeException{
	private String message;

	public EmployeeNotFoundById(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
