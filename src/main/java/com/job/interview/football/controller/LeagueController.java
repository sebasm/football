package com.job.interview.football.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.job.interview.football.exception.FootballAPIException;
import com.job.interview.football.exception.LeagueAlreadyImportedException;
import com.job.interview.football.exception.ResourceNotFoundException;
import com.job.interview.football.exception.TimeOutException;
import com.job.interview.football.service.LeagueService;

@RestController
@RequestMapping(value = "/import-league", produces = "application/json")
public class LeagueController {

	@Autowired
	LeagueService leagueService;

	@RequestMapping(value = "/{leagueCode}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.CREATED)
	public void importLeague(@PathVariable(required = true) String leagueCode) {

		try {
			leagueService.importLeague(leagueCode);
		} catch (LeagueAlreadyImportedException e) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
		} catch (ResourceNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		} catch (TimeOutException e) {
			throw new ResponseStatusException(HttpStatus.GATEWAY_TIMEOUT, e.getMessage());
		} catch (FootballAPIException e) {
			// here we should send a notification to an alerts service
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Contact with the service administrator");
		}

	}

}
