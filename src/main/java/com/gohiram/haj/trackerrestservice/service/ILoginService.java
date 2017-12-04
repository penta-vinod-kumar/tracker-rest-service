package com.gohiram.haj.trackerrestservice.service;

import com.gohiram.haj.trackerrestservice.exception.TrackerException;
import com.gohiram.haj.trackerrestservice.dao.model.UserInformation;

public interface ILoginService {

	public boolean isLoggedIn(String id) throws TrackerException;
	public UserInformation login(UserInformation userinformation) throws TrackerException;
	
	
	
}
