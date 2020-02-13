package com.job.interview.football.repository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.job.interview.football.entity.Competition;

@Repository
public interface CompetitionRepository extends CrudRepository<Competition, Long>{
	
	public Optional<Competition> findByCode(String code);

}
