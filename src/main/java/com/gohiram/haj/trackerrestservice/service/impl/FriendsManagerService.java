package com.gohiram.haj.trackerrestservice.service.impl;

import com.gohiram.haj.trackerrestservice.dao.FriendsRepository;
import com.gohiram.haj.trackerrestservice.dao.UserRepository;
import com.gohiram.haj.trackerrestservice.exception.TrackerException;
import com.gohiram.haj.trackerrestservice.dao.model.Friend;
import com.gohiram.haj.trackerrestservice.dao.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FriendsManagerService {


    @Autowired
    private UserRegistrationService userRegistrationService;

    @Autowired
    private FriendsRepository friendsRepository;

    @Autowired
    private UserRepository userRepository;

    private static final String STATUS_PENDING = "PENDING";
    private static final String STATUS_WAITING = "WAITING";
    private static final String STATUS_CONFIRMED = "CONFIRMED";

    public boolean acceptFriendRequest(long id, long friendId) throws TrackerException {
        try {
            Friend me = friendsRepository.findByMyIdAndFriendId(id, friendId);
            Friend friend = friendsRepository.findByMyIdAndFriendId(friendId, id);
            if (STATUS_PENDING.equals(me.getStatus())) {
                me.setStatus(STATUS_CONFIRMED);
                friendsRepository.save(me);
                friend.setStatus(STATUS_CONFIRMED);
                friendsRepository.save(friend);
            } else {
                throw new TrackerException("Not Possible to Accept ", HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;//friendsRepository.updateFriendRequest(status, id, friendId)>0 && friendsRepository.updateFriendRequest(status, friendId, id)> 0;
    }


    public boolean sendRequest(long id, long friendMobileNumber) throws TrackerException {
        Users friendUserProfile = userRepository.findByMobileNumber(friendMobileNumber);
        if (friendUserProfile == null) {
            throw new TrackerException("User is not registered", HttpStatus.NO_CONTENT);
        }

        if(friendUserProfile.getId().equals(id)){
            throw new TrackerException("You cannot send friend request to your self", HttpStatus.NO_CONTENT);
        }

        if (friendsRepository.findByMyIdAndFriendId(id, friendUserProfile.getId()) != null) {
            throw new TrackerException("Request has been already given from " + id + "to " + friendMobileNumber, HttpStatus.TOO_MANY_REQUESTS);
        }

        Friend me = new Friend();
        me.setMyId(id);
        me.setFriendId(friendUserProfile.getId());
        me.setStatus(STATUS_WAITING);
        me.setCreatedOn(new Date());
        me.setLastUpdated(new Date());

        Friend friend = new Friend();
        friend.setMyId(friendUserProfile.getId());
        friend.setFriendId(id);
        friend.setStatus(STATUS_PENDING);
        friend.setCreatedOn(new Date());
        friend.setLastUpdated(new Date());

        List<Friend> friends = new ArrayList<>();
        friends.add(me);
        friends.add(friend);

        if (friendsRepository.saveAll(friends) == null) {
            throw new TrackerException("Unable to send request from " + id + "to " + friendMobileNumber);
        }

        return true;
    }

    public List<Friend> findAllFriends(long id) throws TrackerException {
        return friendsRepository.findAllByMyId(id);
    }

    public Users findFriendById(long id, long friendId) throws TrackerException {
        if (!userRegistrationService.isUserRegistered(friendId)) {
            throw new TrackerException("User is not registered", HttpStatus.NO_CONTENT);
        }

        return userRegistrationService.readUserInformation(friendId);
    }

    public Boolean deleteFriendById(long id, long friendId) {
        try {
            friendsRepository.deleteByMyIdAndFriendId(id, friendId);
            friendsRepository.deleteByMyIdAndFriendId(friendId, id);
        } catch (Exception e) {
            return false;
        }
        return true;// friendsRepository;
    }
}
