package com.job.interview.football.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.job.interview.football.service.PlayerService;

@RestController
@RequestMapping(value = "/total-players", produces = "application/json")
public class PlayerController {
	
	
	@Autowired
	PlayerService playerService;
	
	@RequestMapping(value = "/{leagueCode}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String importLeague(@PathVariable(required=true) String leagueCode) {
		
		String response = playerService.countPlayersByLeague(leagueCode).toString();
		return response;
		
	}

}
