package com.job.interview.football.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
public class LeagueNotFoundException extends Exception{

	private static final long serialVersionUID = 8776810298426420566L;
	
	public LeagueNotFoundException(String message) {
		super(message);
	}
	
	public LeagueNotFoundException(String message, Throwable throwable) {
		super(message, throwable);
	}

}
