package com.job.interview.football.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.interview.football.api.FootballAPI;
import com.job.interview.football.entity.Competition;

@Service
public class LeagueService {
	
	@Autowired
	FootballAPI footballAPI;
	
	public void importLeague(String leagueCode) {
		
		Competition competition = footballAPI.getCompetition(leagueCode);
		
		System.out.println("asd");
		
	}

}
