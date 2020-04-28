package com.movie.exception.handler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.movie.exception.ErrorDetails;
import com.movie.exception.MovieException;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler{

	@org.springframework.web.bind.annotation.ExceptionHandler({ MovieException.class })
	public ResponseEntity<ErrorDetails> handleMovieNotFoundException(MovieException e) {
		List<String> details = new ArrayList<>();
		details.add(e.getLocalizedMessage());
		ErrorDetails errorDetails = ErrorDetails.of(new Date(), e.getMessage(),details);
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> details = new ArrayList<>();
		for (ObjectError error : ex.getBindingResult().getAllErrors()) {
			details.add(error.getDefaultMessage());
		}
		ErrorDetails errorDetails = ErrorDetails.of(new Date(), "Validation failed!", details);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetails);
	}
}
