package com.job.interview.football.exception;

public class TimeOutException extends RuntimeException{

	private static final long serialVersionUID = 7471489844085262008L;
	
	public TimeOutException() {
		super();
	}
	
	public TimeOutException(String message) {
		super(message);
	}
	
	public TimeOutException(String message, Throwable throwable) {
		super(message, throwable);
	}

}
