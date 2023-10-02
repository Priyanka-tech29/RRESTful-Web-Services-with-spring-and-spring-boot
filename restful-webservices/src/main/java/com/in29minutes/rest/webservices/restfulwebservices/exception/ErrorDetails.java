package com.in29minutes.rest.webservices.restfulwebservices.exception;

import java.time.LocalDateTime;

// create your own custom resources for error msg
//timestamp,message,details
// we want whenever an exception occur we want this specific structure
public class ErrorDetails {

	
	private LocalDateTime timestamp;
	private String message;
	private String details;
	public ErrorDetails(LocalDateTime timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	@Override
	public String toString() {
		return "ErrorDetails [message=" + message + ", details=" + details + "]";
	}
	
	
}
