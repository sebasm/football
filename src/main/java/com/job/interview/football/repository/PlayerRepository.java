package com.job.interview.football.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.job.interview.football.entity.Player;

public interface PlayerRepository extends CrudRepository<Player, Long> {
	
	@Query("SELECT COUNT(p) FROM Player p JOIN p.team.competitions c where c.code=?1")
	Long countPlayersByLeague(String league);

}
