package com.gohiram.haj.trackerrestservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gohiram.haj.trackerrestservice.exception.TrackerException;
import com.gohiram.haj.trackerrestservice.model.TrackerResponse;
import com.gohiram.haj.trackerrestservice.service.ILocationService;

@Controller
@RequestMapping("/locations")
public class LocationController {

	@Autowired
	private ILocationService locationService;

	@RequestMapping(path = "/add-location/{id}/{location}", method = RequestMethod.POST)
	public ResponseEntity<TrackerResponse<Boolean>> addLocation(@PathVariable String id, @PathVariable String location)
			throws TrackerException {
		return new ResponseEntity<>(new TrackerResponse<Boolean>().setData(locationService.addLocation(id, location)),
				HttpStatus.CREATED);

	}

	@RequestMapping(path = "/get-recent-location/{id}", method = RequestMethod.GET)
	public ResponseEntity<TrackerResponse<List<String>>> getLocation(@PathVariable String id) throws TrackerException {
		return new ResponseEntity<>(new TrackerResponse<List<String>>().setData(locationService.getRecentLocations(id)),
				HttpStatus.OK);
	}
	
	

}
