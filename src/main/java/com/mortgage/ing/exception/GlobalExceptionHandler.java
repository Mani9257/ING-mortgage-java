package com.mortgage.ing.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(IngMortgageException.class)
	public ResponseEntity<ResponseDto> mortgageExceptionHandler(IngMortgageException ex, WebRequest request) {
		ResponseDto responseDto =new ResponseDto(ex.getMessage(),HttpStatus.BAD_REQUEST.value());

		return new ResponseEntity<>(responseDto, HttpStatus.UNAUTHORIZED);

	}

	@ExceptionHandler(HttpStatusCodeException.class)
	public ResponseEntity<String> mortgageExceptionHandler(HttpStatusCodeException ex, WebRequest request) {
		return ResponseEntity.status(ex.getRawStatusCode()).body(ex.getResponseBodyAsString());

	}


}