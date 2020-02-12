package com.job.interview.football.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Competition {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	String name;
	String code;
	String areaName;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
			name="competition_team", 
			joinColumns = { @JoinColumn(name = "competition_id")},
			inverseJoinColumns = { @JoinColumn(name = "team_id")})
	List<Team> teams;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public List<Team> getTeams() {
		return teams;
	}
	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
	
	
}
