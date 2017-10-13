package com.gohiram.haj.trackerrestservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gohiram.haj.trackerrestservice.dao.ILoginDao;
import com.gohiram.haj.trackerrestservice.exception.TrackerException;
import com.gohiram.haj.trackerrestservice.model.UserInformation;
import com.gohiram.haj.trackerrestservice.service.ILoginService;

@Service
public class LoginService implements ILoginService {

	@Autowired
	private ILoginDao loginDao;

	@Override
	public boolean isLoggedIn(String id) throws TrackerException {

		return loginDao.isLoggedIn(id);
	}

	@Override
	public UserInformation login(UserInformation userinformation) throws TrackerException {

		return loginDao.login(userinformation);
	}

}
