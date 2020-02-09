package com.job.interview.football.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.job.interview.football.entity.Competition;

@Component
public class FootballAPI {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${api.football.url}")
	private String url;

	@Value("${api.football.token}")
	private String token;

	public Competition getCompetition(String leagueCode) {

		String competitionsURL = url + "/competitions/" + leagueCode;

		ResponseEntity<Competition> response = restTemplate.exchange(competitionsURL, HttpMethod.GET,
				new HttpEntity<Competition>(createHeaders()),
				new ParameterizedTypeReference<Competition>() {
				});
		Competition data = response.getBody();
		return data;
	}

	private HttpHeaders createHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("X-Auth-Token", token);
		return headers;
	}

}
