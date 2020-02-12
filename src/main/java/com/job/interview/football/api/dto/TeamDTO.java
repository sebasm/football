package com.job.interview.football.api.dto;

import java.util.List;

public class TeamDTO {
	
	String id;
	String name;
	String tla;
	String shortName;
	String areaName;
	String email;
	List<PlayerDTO> squad;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTla() {
		return tla;
	}
	public void setTla(String tla) {
		this.tla = tla;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<PlayerDTO> getSquad() {
		return squad;
	}
	public void setSquad(List<PlayerDTO> squad) {
		this.squad = squad;
	}
	

}
