package com.job.interview.football.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.job.interview.football.service.LeagueService;

@RestController
@RequestMapping(value = "/import-league", produces = "application/json")
public class LeagueController {
	
	@Autowired
	LeagueService leagueService;
	
	@RequestMapping(value = "/{leagueCode}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.CREATED)
	public void importLeague(@PathVariable(required=true) String leagueCode) {
		
		leagueService.importLeague(leagueCode);
		
	}

}
