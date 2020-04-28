package com.movie.exception.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.movie.exception.ErrorDetails;
import com.movie.exception.MovieException;

@ControllerAdvice
public class ExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler({ MovieException.class })
	public ResponseEntity<ErrorDetails> handleUserNotFoundException(MovieException e) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), e.getMessage());
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}
}
