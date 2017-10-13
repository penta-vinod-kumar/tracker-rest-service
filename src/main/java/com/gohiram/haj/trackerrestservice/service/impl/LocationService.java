package com.gohiram.haj.trackerrestservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.gohiram.haj.trackerrestservice.dao.ILocationDao;
import com.gohiram.haj.trackerrestservice.dao.LocationRepository;
import com.gohiram.haj.trackerrestservice.exception.TrackerException;
import com.gohiram.haj.trackerrestservice.service.ILocationService;

@Service
public class LocationService implements ILocationService {

	@Autowired
	private ILocationDao locationDao;
	
	@Autowired
	private LocationRepository locationRepository;
	
	private static PageRequest page=PageRequest.of(0,5);
	
	@Override
	public boolean addLocation(String id, String location) throws TrackerException {
		
		return locationDao.addLocation(id, location);
	}

	
	public List<String> getRecentLocations(String id) throws TrackerException {
		
		return locationRepository.findAll(id,page);
	}


	
}
