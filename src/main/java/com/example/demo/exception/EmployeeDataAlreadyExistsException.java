package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EmployeeDataAlreadyExistsException extends RuntimeException {
	
    private String message;
    public EmployeeDataAlreadyExistsException() {}
	public EmployeeDataAlreadyExistsException(String message) {
		super(message);
		this.message=message;
		// TODO Auto-generated constructor stub
	}
	
	
	

}
