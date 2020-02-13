package com.job.interview.football.exception;

public class LeagueAlreadyImportedException extends RuntimeException{

	private static final long serialVersionUID = 4206634467600323830L;
	
	public LeagueAlreadyImportedException(String message) {
		super(message);
	}
	
	public LeagueAlreadyImportedException(String message, Throwable throwable) {
		super(message, throwable);
	}

}
