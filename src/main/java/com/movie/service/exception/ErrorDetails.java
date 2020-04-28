package com.movie.service.exception;
import java.util.Date;

public class ErrorDetails {
	private Date timestamp;
	private String message;

	public ErrorDetails(java.util.Date date, String message) {
		super();
		this.timestamp = date;
		this.message = message;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

}