package com.gohiram.haj.trackerrestservice.dao;

import com.gohiram.haj.trackerrestservice.exception.TrackerException;
import com.gohiram.haj.trackerrestservice.model.UserInformation;

public interface ILoginDao {

	
	public boolean isLoggedIn(String id) throws TrackerException;
	public UserInformation login(UserInformation userinformation) throws TrackerException;
	
}
