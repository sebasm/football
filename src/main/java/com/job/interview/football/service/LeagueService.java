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
import com.job.interview.football.exception.LeagueNotFoundException;
import com.job.interview.football.repository.CompetitionRepository;

@Service
public class LeagueService {
	
	@Autowired
	FootballAPI footballAPI;
	
	@Autowired
	FootballMapper footballMapper;
	
	@Autowired
	CompetitionRepository competitionRepository;
	
	public void importLeague(String leagueCode) {
		
		CompetitionDTO competitionDTO = null;
		try {
			competitionDTO = footballAPI.getCompetition(leagueCode);
			if(competitionDTO == null) {
				throw new LeagueNotFoundException("asd");
			}
		} catch (Exception e) {
		}
		
		Competition competition = footballMapper.map(competitionDTO);
		
		
		
		TeamResultDTO trdto = footballAPI.getTeamsByLeague(leagueCode);
		
		List<Team> teams = trdto.getTeams().stream().map(footballMapper::map).collect(Collectors.toList());
		
		List<Team> temp = new ArrayList<Team>();
		temp.add(teams.get(0));
		temp.add(teams.get(1));
		
		for (Team team : temp) {
			TeamDTO teamDTO = footballAPI.getTeamById(team.getId());
			List<Player> players = teamDTO.getSquad().stream().map(footballMapper::map).collect(Collectors.toList());
			team.setPlayers(players);
			System.out.println("Importing " + team.getName());
			try {
				Thread.sleep(6001);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		competition.setTeams(teams);
		
		competitionRepository.save(competition);

		
	}

}
