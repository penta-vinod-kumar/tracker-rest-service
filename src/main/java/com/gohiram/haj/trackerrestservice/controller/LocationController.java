package com.gohiram.haj.trackerrestservice.controller;

import com.gohiram.haj.trackerrestservice.dao.model.Location;
import com.gohiram.haj.trackerrestservice.exception.TrackerException;
import com.gohiram.haj.trackerrestservice.dao.model.TrackerResponse;
import com.gohiram.haj.trackerrestservice.model.LocationResponse;
import com.gohiram.haj.trackerrestservice.service.impl.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@CrossOrigin
@RestController
@RequestMapping("/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @RequestMapping(path = "/add-location/{id}", method = RequestMethod.POST)
    public ResponseEntity<TrackerResponse<Boolean>> addLocation(@PathVariable Long id, @RequestBody Location location)
            throws TrackerException {
        return new ResponseEntity<>(new TrackerResponse<Boolean>().setData(locationService.addLocation(id, location)),
                HttpStatus.CREATED);

    }

    @RequestMapping(path = "/get-recent-location/{id}", method = RequestMethod.GET)
    public ResponseEntity<TrackerResponse<Location>> getLocation(@PathVariable String id) throws TrackerException {
        return new ResponseEntity<>(new TrackerResponse<Location>().setData(locationService.getRecentLocations(id)), HttpStatus.OK);
    }

    @RequestMapping(path = "/get-friends-location/{id}", method = RequestMethod.GET)
    public ResponseEntity<TrackerResponse<List<LocationResponse>>> getFriendLocations(@PathVariable String id) throws TrackerException {
        return new ResponseEntity<>(new TrackerResponse<List<LocationResponse>>().setData(locationService.getFriendLocations(id)), HttpStatus.OK);
    }



}
