package com.job.interview.football.exception;

public class FootballAPIException extends RuntimeException{

	private static final long serialVersionUID = -7443265408492961006L;
	
	public FootballAPIException() {
		super();
	}
	
	public FootballAPIException(String message) {
		super(message);
	}
	
	public FootballAPIException(String message, Throwable throwable) {
		super(message, throwable);
	}

}
