package com.qatelo.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {


	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorObject> handleUserNotFound(UserNotFoundException e, WebRequest request) {
		ErrorObject errorObject = new ErrorObject();
		errorObject.setStatus(HttpStatus.NOT_FOUND.value());
		errorObject.setMessage(e.getMessage());
		errorObject.setTimestamp(new Date());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorObject);
	}

	@ExceptionHandler(UserInvalidCredentialsException.class)
	public ResponseEntity<ErrorObject> handleInvalidCredentials(UserInvalidCredentialsException e) {
		ErrorObject errorObject = new ErrorObject();
		errorObject.setStatus(HttpStatus.UNAUTHORIZED.value());
		errorObject.setMessage(e.getMessage());
		errorObject.setTimestamp(new Date());
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorObject);
	}

	@ExceptionHandler(ChangePasswordException.class)
	public ResponseEntity<ErrorObject> handleChangePassword(ChangePasswordException e) {
		ErrorObject errorObject = new ErrorObject();
		errorObject.setStatus(HttpStatus.UNAUTHORIZED.value());
		errorObject.setMessage(e.getMessage());
		errorObject.setTimestamp(new Date());
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorObject);

	}
}
