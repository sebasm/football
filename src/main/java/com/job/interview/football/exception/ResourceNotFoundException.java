package com.job.interview.football.exception;

public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 8776810298426420566L;
	
	public ResourceNotFoundException() {
		super();
	}
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
	
	public ResourceNotFoundException(String message, Throwable throwable) {
		super(message, throwable);
	}

}
