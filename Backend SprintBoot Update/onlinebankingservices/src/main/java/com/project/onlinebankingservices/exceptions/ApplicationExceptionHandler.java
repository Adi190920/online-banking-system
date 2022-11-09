package com.project.onlinebankingservices.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationExceptionHandler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleInva1idArgument(MethodArgumentNotValidException ex) {
		Map<String, String> errorMap = new HashMap<>();
		ex.getBindingResult().getFieldErrors()
				.forEach(error -> errorMap.put(error.getField(), error.getDefaultMessage()));
		return errorMap;
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NotFoundException.class)
	public Map<String, String> handleBusinessException(NotFoundException ex) {
		Map<String, String> errorMap = new HashMap<>();
		errorMap.put(" errorMessage ", ex.getMessage());
		return errorMap;
	}
	
	@ResponseStatus(HttpStatus.ALREADY_REPORTED)
	@ExceptionHandler(AlreadyFoundException.class)
	public Map<String, String> handleBException(AlreadyFoundException ex) {
		Map<String, String> errorMap = new HashMap<>();
		errorMap.put(" errorMessage ", ex.getMessage());
		return errorMap;
	}
}