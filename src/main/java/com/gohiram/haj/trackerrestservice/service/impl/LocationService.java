package com.gohiram.haj.trackerrestservice.service.impl;

import com.gohiram.haj.trackerrestservice.dao.FriendsRepository;
import com.gohiram.haj.trackerrestservice.dao.LocationRepository;
import com.gohiram.haj.trackerrestservice.dao.UserRepository;
import com.gohiram.haj.trackerrestservice.dao.model.Location;
import com.gohiram.haj.trackerrestservice.exception.TrackerException;
import com.gohiram.haj.trackerrestservice.model.LocationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private FriendsRepository friendsRepository;

    @Autowired
    private UserRepository userRepository;

    public Boolean addLocation(Long id, Location location) throws TrackerException {
        Location loc = locationRepository.findById(id).orElse(new Location());
        loc.setLastUpdated(new Date());
        loc.setLan(location.getLan());
        loc.setLat(location.getLat());
        loc.setId(id);
        try {
            locationRepository.save(loc);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public Location getRecentLocations(String id) throws TrackerException {
        Location location = locationRepository.findById(Long.valueOf(id)).orElse(new Location());
        return location;
    }

    public List<LocationResponse> getFriendLocations(String id) {
        List<LocationResponse> locations = friendsRepository.findAllByMyId(Long.valueOf(id)).stream().map(friend -> {
            LocationResponse locationResponse = new LocationResponse();
            locationResponse.setLocation(locationRepository.findById(friend.getFriendId()).get());
            locationResponse.setUser(userRepository.findById(friend.getFriendId()).get());
            return locationResponse;
        }).collect(Collectors.toList());
        return locations;
    }
}
