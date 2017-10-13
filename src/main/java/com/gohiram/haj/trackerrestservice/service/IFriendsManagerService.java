package com.gohiram.haj.trackerrestservice.service;

import java.util.List;

import com.gohiram.haj.trackerrestservice.exception.TrackerException;
import com.gohiram.haj.trackerrestservice.model.Friend;
import com.gohiram.haj.trackerrestservice.model.UserInformation;

public interface IFriendsManagerService {


	public boolean sendRequest(long id, long friendId) throws TrackerException;

	public List<Friend> findAllFriends(long id) throws TrackerException;

	public UserInformation findFriendById(long id, long friendId) throws TrackerException;

	boolean acceptFriendRequest(long id, long friendId, String status) throws TrackerException;

}
