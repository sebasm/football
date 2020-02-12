package com.job.interview.football.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import com.job.interview.football.entity.Competition;

@Repository
public interface CompetitionRepository extends CrudRepository<Competition, Long>{

}
