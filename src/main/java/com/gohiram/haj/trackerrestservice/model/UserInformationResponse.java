package com.gohiram.haj.trackerrestservice.model;

import com.gohiram.haj.trackerrestservice.dao.model.Friend;
import com.gohiram.haj.trackerrestservice.dao.model.Location;
import com.gohiram.haj.trackerrestservice.dao.model.Users;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserInformationResponse {

    private Users profile;
    private Location location;
    private List<Users> friends;
    private List<Location> friendsLocations;
    private List<Friend> friendsStatus;


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

    public List<Friend> getFriendsStatus() {
        if (friendsStatus == null)
            friendsStatus = new ArrayList<>();
        return friendsStatus;
    }
}
