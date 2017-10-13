package com.gohiram.haj.trackerrestservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gohiram.haj.trackerrestservice.dao.UserRepository;
import com.gohiram.haj.trackerrestservice.exception.TrackerException;
import com.gohiram.haj.trackerrestservice.model.UserInformation;
import com.gohiram.haj.trackerrestservice.service.IUserRegistrationService;


@Service
public class UserRegistrationService implements IUserRegistrationService {

	/*@Autowired
	private IUserRegistrationDao userRegistrationDao;*/

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public boolean registerUser(UserInformation userInformation) throws TrackerException {
		return userRepository.save(userInformation)!=null;
	}

	@Override
	public boolean isUserRegistered(Long id) throws TrackerException {
		return userRepository.existsById(id);
	}

	@Override
	public UserInformation readUserInformation(long id) throws TrackerException {
		return userRepository.findById(id).orElse(null);
	}

	
}
