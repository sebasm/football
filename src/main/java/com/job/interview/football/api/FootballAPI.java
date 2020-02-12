package com.job.interview.football.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.job.interview.football.api.dto.CompetitionDTO;
import com.job.interview.football.api.dto.PlayerDTO;
import com.job.interview.football.api.dto.TeamDTO;
import com.job.interview.football.api.dto.TeamResultDTO;
import com.job.interview.football.entity.Competition;

@Component
public class FootballAPI {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${api.football.url}")
	private String url;

	@Value("${api.football.token}")
	private String token;

	public CompetitionDTO getCompetition(String leagueCode) {

		String competitionsURL = url + "/competitions/" + leagueCode;

		ResponseEntity<CompetitionDTO> response = restTemplate.exchange(competitionsURL, HttpMethod.GET,
				new HttpEntity<CompetitionDTO>(createHeaders()),
				new ParameterizedTypeReference<CompetitionDTO>() {
				});
		if(response.getStatusCode() == HttpStatus.NOT_FOUND) {
			
		}
		else if(response.getStatusCode().is5xxServerError()) {
			
		}{
			
		}
		CompetitionDTO data = response.getBody();
		return data;
	}
	
	public TeamResultDTO getTeamsByLeague(String league) {
		
		String teamsURL = url + "/competitions/" + league + "/teams";
		
		ResponseEntity<TeamResultDTO> response = restTemplate.exchange(teamsURL, HttpMethod.GET,
				new HttpEntity<TeamResultDTO>(createHeaders()),
				new ParameterizedTypeReference<TeamResultDTO>() {
				});
		
		TeamResultDTO trdto = response.getBody();
		
		return trdto;
	}
	
	public TeamDTO getTeamById(Long teamId) {
		
		String teamsURL = url + "/teams/" + teamId;
		
		ResponseEntity<TeamDTO> response = restTemplate.exchange(teamsURL, HttpMethod.GET,
				new HttpEntity<TeamDTO>(createHeaders()),
				new ParameterizedTypeReference<TeamDTO>() {
				});
		
		TeamDTO team = response.getBody();
		
		return team;
	}

	private HttpHeaders createHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("X-Auth-Token", token);
		return headers;
	}

}
