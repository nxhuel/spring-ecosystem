package com.nxhu.restfull_api.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.nxhu.restfull_api.dto.response.ErrorResponse;

@ControllerAdvice
public class GlobalControllerAdvice extends ResponseEntityExceptionHandler {

//	slice article
	@ExceptionHandler(ArticleNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<ErrorResponse> userNotFoundException(ArticleNotFoundException exception) {
		ErrorResponse message = ErrorResponse.builder().status(HttpStatus.NOT_FOUND).message(exception.getMessage())
				.timestamp(LocalDateTime.now()).build();

		return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
	}

//	global validation
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		Map<String, Object> errors = new HashMap<String, Object>();
	
		ex.getBindingResult().getFieldErrors().forEach(error -> {
			errors.put(error.getField(), error.getDefaultMessage());
		});

		return new ResponseEntity<>(errors , HttpStatus.BAD_REQUEST);
	}

}
