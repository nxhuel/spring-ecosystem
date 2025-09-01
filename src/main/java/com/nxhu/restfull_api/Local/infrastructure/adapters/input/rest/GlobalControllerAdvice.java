package com.nxhu.restfull_api.Local.infrastructure.adapters.input.rest;

import java.net.http.HttpHeaders;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.nxhu.restfull_api.Local.domain.exception.LocalNotFoundException;
import com.nxhu.restfull_api.Local.infrastructure.adapters.input.rest.model.response.ErrorResponse;

@ControllerAdvice
public class GlobalControllerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(LocalNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<ErrorResponse> localNotFoundException(LocalNotFoundException exception) {
		ErrorResponse message = ErrorResponse.builder().status(HttpStatus.NOT_FOUND).message(exception.getMessage())
				.details(List.of()).timestamp(LocalDateTime.now()).build();
		return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
	}

	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		List<String> details = ex.getBindingResult().getFieldErrors().stream()
				.map(error -> error.getField() + ": " + error.getDefaultMessage()).toList();

		ErrorResponse errorResponse = ErrorResponse.builder().status(HttpStatus.BAD_REQUEST)
				.message("Validation failed").details(details).timestamp(LocalDateTime.now()).build();

		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
}
