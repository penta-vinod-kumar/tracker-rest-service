package com.gohiram.haj.trackerrestservice.model;

import com.gohiram.haj.trackerrestservice.dao.model.Location;
import com.gohiram.haj.trackerrestservice.dao.model.Users;
import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserInformationResponse {

    private Users profile;
    private Location location;
    private List<Users> friends;
    private List<Location> friendsLocations;

    public List<Users> getFriends() {
        if (friends == null)
            friends = new ArrayList<>();
        return friends;
    }

    public List<Location> getFriendsLocations() {
        if (friendsLocations == null)
            friendsLocations = new ArrayList<>();
        return friendsLocations;
    }
}
