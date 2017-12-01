package com.gohiram.haj.trackerrestservice.service.impl;

import com.gohiram.haj.trackerrestservice.dao.LocationRepository;
import com.gohiram.haj.trackerrestservice.exception.TrackerException;
import com.gohiram.haj.trackerrestservice.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public Boolean addLocation(Long id, String location) throws TrackerException {
        Location loc = locationRepository.findById(id).orElse(new Location());
        loc.setLastUpdated(new Date());
        loc.setLocation(location);
        loc.setId(id);
        try {
            locationRepository.save(loc);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public String getRecentLocations(String id) throws TrackerException {
        Location location = locationRepository.findById(Long.valueOf(id)).orElse(new Location());
        return location.getLocation();
    }


}
