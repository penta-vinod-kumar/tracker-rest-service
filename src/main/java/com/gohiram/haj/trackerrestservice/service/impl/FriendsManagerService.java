package com.gohiram.haj.trackerrestservice.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.gohiram.haj.trackerrestservice.dao.FriendsRepository;
import com.gohiram.haj.trackerrestservice.exception.TrackerException;
import com.gohiram.haj.trackerrestservice.model.Friend;
import com.gohiram.haj.trackerrestservice.model.UserInformation;
import com.gohiram.haj.trackerrestservice.service.IFriendsManagerService;
import com.gohiram.haj.trackerrestservice.service.IUserRegistrationService;

@Service
public class FriendsManagerService implements IFriendsManagerService {


	@Autowired
	private IUserRegistrationService userRegistrationService;

	@Autowired
	private FriendsRepository friendsRepository;

	private static final String STATUS_PENDING = "PENDING";
	
	@Override
	public boolean acceptFriendRequest(long id, long friendId, String status) throws TrackerException {

		return friendsRepository.updateFriendRequest(status, id, friendId)>0 && friendsRepository.updateFriendRequest(status, friendId, id)> 0;
	}

	

	@Override
	public boolean sendRequest(long id, long friendId) throws TrackerException {

		if (!userRegistrationService.isUserRegistered(friendId)) {
			throw new TrackerException("User is not registered", HttpStatus.NO_CONTENT);
		}

		if (friendsRepository.isFriendAlready(id, friendId) > 0) {
			throw new TrackerException("Request has been already given from " + id + "to " + friendId,
					HttpStatus.TOO_MANY_REQUESTS);
		}

		Friend friend = new Friend();
		friend.setFriendId(friendId);
		friend.setId(id);

		List<Friend> friends = new ArrayList<>();
		friends.add(new Friend(id, friendId, STATUS_PENDING));
		friends.add(new Friend(friendId, id, STATUS_PENDING));

		if (friendsRepository.saveAll(friends) == null) {
			throw new TrackerException("Unable to send request from " + id + "to " + friendId);
		}

		return true;
	}

	@Override
	public List<Friend> findAllFriends(long id) throws TrackerException {

		return friendsRepository.findAllFriends(id);
	}

	@Override
	public UserInformation findFriendById(long id, long friendId) throws TrackerException {
		if (!userRegistrationService.isUserRegistered(friendId)) {
			throw new TrackerException("User is not registered", HttpStatus.NO_CONTENT);
		}

		if (friendsRepository.isFriendAlready(id, friendId) > 0) {
			throw new TrackerException("Request has been already given from " + id + "to " + friendId,
					HttpStatus.TOO_MANY_REQUESTS);
		}

		return userRegistrationService.readUserInformation(friendId);
	}

}
