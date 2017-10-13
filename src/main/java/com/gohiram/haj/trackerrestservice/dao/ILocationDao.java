package com.gohiram.haj.trackerrestservice.dao;

import java.util.List;

import com.gohiram.haj.trackerrestservice.exception.TrackerException;

public interface ILocationDao {

	public boolean addLocation(String id,String location) throws TrackerException;
	
	public List<String> getRecentLocations(String id) throws TrackerException;
	
	public String  getRecentLocation(String id) throws TrackerException;
	
}
