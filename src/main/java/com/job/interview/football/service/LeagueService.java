package com.job.interview.football.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.interview.football.api.FootballAPI;
import com.job.interview.football.api.dto.CompetitionDTO;
import com.job.interview.football.api.dto.PlayerDTO;
import com.job.interview.football.api.dto.TeamDTO;
import com.job.interview.football.api.dto.TeamResultDTO;
import com.job.interview.football.api.mapper.FootballMapper;
import com.job.interview.football.entity.Competition;
import com.job.interview.football.entity.Player;
import com.job.interview.football.entity.Team;
import com.job.interview.football.exception.LeagueAlreadyImportedException;
import com.job.interview.football.exception.ResourceNotFoundException;
import com.job.interview.football.repository.CompetitionRepository;

@Service
public class LeagueService {
	
	private static final int DELAY_TIME = 7001;

	@Autowired
	FootballAPI footballAPI;
	
	@Autowired
	FootballMapper footballMapper;
	
	@Autowired
	CompetitionRepository competitionRepository;
	
	
	public void importLeague(String leagueCode) {
		
		
		if(competitionRepository.findByCode(leagueCode).isPresent()) {
			throw new LeagueAlreadyImportedException("League already imported.");
		}
		
		CompetitionDTO competitionDTO = footballAPI.getCompetition(leagueCode);
		Competition competition = footballMapper.map(competitionDTO);
		
		TeamResultDTO teamResultDTO = footballAPI.getTeamsByLeague(leagueCode);
		List<Team> teams = teamResultDTO.getTeams().stream().map(footballMapper::map).collect(Collectors.toList());
		
		// this should be refactored depending of the API max request limitation solution
		for (Team team : teams) {
			TeamDTO teamDTO = footballAPI.getTeamById(team.getId());
			List<Player> players = teamDTO.getSquad().stream().map(footballMapper::map).collect(Collectors.toList());
			team.setPlayers(players);
			System.out.println("Importing " + team.getName());
			try {
				Thread.sleep(DELAY_TIME);
			} catch (InterruptedException e) {
				throw new RuntimeException("Error handling API delay interruption", e);
			}
		}
		
		competition.setTeams(teams);
		
		competitionRepository.save(competition);
		
	}

}
