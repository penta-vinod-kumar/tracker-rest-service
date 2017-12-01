package com.gohiram.haj.trackerrestservice.service.impl;

import com.gohiram.haj.trackerrestservice.dao.FriendsRepository;
import com.gohiram.haj.trackerrestservice.exception.TrackerException;
import com.gohiram.haj.trackerrestservice.model.Friend;
import com.gohiram.haj.trackerrestservice.model.UserInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FriendsManagerService {


    @Autowired
    private UserRegistrationService userRegistrationService;

    @Autowired
    private FriendsRepository friendsRepository;

    private static final String STATUS_PENDING = "PENDING";

    public boolean acceptFriendRequest(long id, long friendId, String status) throws TrackerException {

        return true;//friendsRepository.updateFriendRequest(status, id, friendId)>0 && friendsRepository.updateFriendRequest(status, friendId, id)> 0;
    }


    public boolean sendRequest(long id, long friendId) throws TrackerException {

        if (!userRegistrationService.isUserRegistered(friendId)) {
            throw new TrackerException("User is not registered", HttpStatus.NO_CONTENT);
        }

		/*if (friendsRepository.isFriendAlready(id, friendId) > 0) {
            throw new TrackerException("Request has been already given from " + id + "to " + friendId,
					HttpStatus.TOO_MANY_REQUESTS);
		}*/

        Friend friend = new Friend();
        friend.setFriendId(friendId);
        friend.setId(id);

        List<Friend> friends = new ArrayList<>();
        //friends.add(new Friend(id, friendId, STATUS_PENDING));
        //friends.add(new Friend(friendId, id, STATUS_PENDING));

        if (friendsRepository.saveAll(friends) == null) {
            throw new TrackerException("Unable to send request from " + id + "to " + friendId);
        }

        return true;
    }

    public List<Friend> findAllFriends(long id) throws TrackerException {

        return new ArrayList<>();//friendsRepository.findAllFriends(id);
    }

    public UserInformation findFriendById(long id, long friendId) throws TrackerException {
        if (!userRegistrationService.isUserRegistered(friendId)) {
            throw new TrackerException("User is not registered", HttpStatus.NO_CONTENT);
        }

		/*if (friendsRepository.isFriendAlready(id, friendId) > 0) {
			throw new TrackerException("Request has been already given from " + id + "to " + friendId,
					HttpStatus.TOO_MANY_REQUESTS);
		}*/

        return null;//userRegistrationService.readUserInformation(friendId);
    }

}
