package com.gohiram.haj.trackerrestservice.service;

import com.gohiram.haj.trackerrestservice.exception.TrackerException;
import com.gohiram.haj.trackerrestservice.model.UserInformation;

public interface IUserRegistrationService {

	public boolean registerUser(UserInformation userInformation) throws TrackerException;
	boolean isUserRegistered(Long id) throws TrackerException;
	UserInformation readUserInformation(long id) throws TrackerException;
}
