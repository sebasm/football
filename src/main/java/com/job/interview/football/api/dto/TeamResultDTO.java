package com.job.interview.football.api.dto;

import java.util.List;

public class TeamResultDTO {
	
	Integer count;
	List<TeamDTO> teams;
	
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public List<TeamDTO> getTeams() {
		return teams;
	}
	public void setTeams(List<TeamDTO> teams) {
		this.teams = teams;
	}
	
	
	

}
