package com.job.interview.football.api.mapper;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.job.interview.football.api.dto.CompetitionDTO;
import com.job.interview.football.api.dto.PlayerDTO;
import com.job.interview.football.api.dto.TeamDTO;
import com.job.interview.football.entity.Competition;
import com.job.interview.football.entity.Player;
import com.job.interview.football.entity.Team;

@Component
public class FootballMapper {
	
	public Competition map(CompetitionDTO cdto) {
		Competition competition = new Competition();
		competition.setId(cdto.getId());
		competition.setAreaName(cdto.getAreaName());
		competition.setCode(cdto.getCode());
		competition.setName(cdto.getName());
		return competition;
	}
	
	
	public Team map(TeamDTO tdto) {
		Team team = new Team();
		team.setAreaName(tdto.getAreaName());
		team.setEmail(tdto.getEmail());
		team.setId(Long.valueOf(tdto.getId()));
		team.setName(tdto.getName());
		team.setShortName(tdto.getName());
		team.setTla(tdto.getTla());
		
		return team;
	}
	
	public Player map(PlayerDTO pdto) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
		Date dateOfBirth = null;
		try {
			dateOfBirth = formatter.parse(pdto.getDateOfBirth());
		} catch (Exception e) {
			// Do nothing, sometimes birthday is null.
		}
		Player player = new Player();
		player.setId(pdto.getId());
		player.setCountryOfBirth(pdto.getCountryOfBirth());
		player.setDateOfBirth(dateOfBirth);
		player.setName(pdto.getName());
		player.setNationality(pdto.getNationality());
		player.setPosition(pdto.getPosition());
		return player;
	}

}
