package com.github.antoniomauriciofg96.realestateapp.infra;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ExceptionHandlers {
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<?> handleNotFound() {
		return ResponseEntity.notFound().build();
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<FieldErrorData>> handleBadRequest(MethodArgumentNotValidException ex) {
		List<FieldError> errors = ex.getFieldErrors();
		return ResponseEntity.badRequest().body(errors.stream().map(FieldErrorData::new).toList());
	}
	
	private record FieldErrorData(String field, String message) {
		public FieldErrorData(FieldError error) {
			this(error.getField(), error.getDefaultMessage());
		}
	}

}
