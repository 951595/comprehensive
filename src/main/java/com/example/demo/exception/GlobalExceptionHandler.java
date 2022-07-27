package com.example.demo.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
@ControllerAdvice
public class GlobalExceptionHandler {
	
	//handling specific exception
	@ExceptionHandler(EmployeeDataAlreadyExistsException.class)
	public ResponseEntity<?> EmployeeDataAlreadyExistsExceptionHandling(EmployeeDataAlreadyExistsException ex, WebRequest request){
	
		ErrorResponse ep=new ErrorResponse(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(ep, HttpStatus.NOT_FOUND);	
	
	}
	
	//handling global exception
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globalExceptionHandling(Exception ex, WebRequest request){
		ErrorResponse ep=new ErrorResponse(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(ep, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

}
