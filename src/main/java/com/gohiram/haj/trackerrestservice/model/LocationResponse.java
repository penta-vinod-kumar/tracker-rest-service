package com.gohiram.haj.trackerrestservice.model;

import com.gohiram.haj.trackerrestservice.dao.model.Location;
import com.gohiram.haj.trackerrestservice.dao.model.Users;
import lombok.Data;

@Data
public class LocationResponse {
    private Location location;
    private Users user;

}
