package com.inventory.api.controller;

import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.inventory.api.exception.ProductNotFoundException;
import com.inventory.api.model.ErrorResponse;


@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(value = SQLException.class)
	public ResponseEntity<Object> exception(SQLException exception) {
		ErrorResponse response = new ErrorResponse();
		response.setError_code(500);
		response.setError_message("Someting went wrong. Please contact with administrator.");
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = ProductNotFoundException.class)
	public ResponseEntity<Object> exception(ProductNotFoundException exception) {
		ErrorResponse response = new ErrorResponse();
		response.setError_code(404);
		response.setError_message(exception.getMessage());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = BadCredentialsException.class)
	public ResponseEntity<Object> exception(BadCredentialsException exception) {
		ErrorResponse response = new ErrorResponse();
		response.setError_code(401);
		response.setError_message(exception.getMessage());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = UsernameNotFoundException.class)
	public ResponseEntity<Object> exception(UsernameNotFoundException exception) {
		ErrorResponse response = new ErrorResponse();
		response.setError_code(404);
		response.setError_message(exception.getMessage());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
}
