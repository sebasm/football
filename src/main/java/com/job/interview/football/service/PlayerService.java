package com.job.interview.football.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.interview.football.repository.PlayerRepository;

@Service
public class PlayerService {
	
	@Autowired
	PlayerRepository playerRepository;
	
	public Long countPlayersByLeague(String league) {
		
		return playerRepository.countPlayersByLeague(league);
	}

}
