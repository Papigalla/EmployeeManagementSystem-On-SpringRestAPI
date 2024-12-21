package com.example.Employee_Management_System.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.Employee_Management_System.exception.EmployeeNotFoundById;


@RestControllerAdvice
public class ApplicationExceptionHandler {
@ExceptionHandler
public ResponseEntity<ErrorStructure> handleEmployeeNotFoundId(EmployeeNotFoundById ex) {
	
	return ResponseEntity.status(HttpStatus.NOT_FOUND)
			.body(ErrorStructure.create(HttpStatus.NOT_FOUND.value(),ex.getMessage(),"Employee Not found for the given Id"));
}
}
