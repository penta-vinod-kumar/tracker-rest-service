package com.gohiram.haj.trackerrestservice.dao.impl;

import org.springframework.stereotype.Repository;

import com.gohiram.haj.trackerrestservice.dao.ILoginDao;
import com.gohiram.haj.trackerrestservice.exception.TrackerException;
import com.gohiram.haj.trackerrestservice.model.UserInformation;


@Repository
public class LoginDao implements ILoginDao {

	@Override
	public boolean isLoggedIn(String id) throws TrackerException {
		
		return false;
	}

	@Override
	public UserInformation login(UserInformation userinformation) throws TrackerException {
		
		return null;
	}

}
