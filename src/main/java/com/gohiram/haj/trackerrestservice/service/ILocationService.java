package com.gohiram.haj.trackerrestservice.service;

import java.util.List;

import com.gohiram.haj.trackerrestservice.exception.TrackerException;

public interface ILocationService {

	public boolean addLocation(String id, String location) throws TrackerException;

	public List<String> getRecentLocations(String id) throws TrackerException;

}
