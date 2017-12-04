package com.gohiram.haj.trackerrestservice.service.impl;

import com.gohiram.haj.trackerrestservice.dao.UserRepository;
import com.gohiram.haj.trackerrestservice.exception.TrackerException;
import com.gohiram.haj.trackerrestservice.dao.model.UserInformation;
import com.gohiram.haj.trackerrestservice.dao.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserRegistrationService {

    @Autowired
    private UserRepository userRepository;

    public Users registerUser(UserInformation userInformation) throws TrackerException {
        Users users = createUser(userInformation);
        return userRepository.save(users);
    }

    private Users createUser(UserInformation userInformation) {
        Users users = new Users();
        users.setEmailId(userInformation.getEmailId());
        users.setFirstName(userInformation.getFirstName());
        users.setLastName(userInformation.getLastName());
        users.setMobileNumber(userInformation.getMobileNumber());
        return users;
    }

    public boolean isUserRegistered(Long id) throws TrackerException {
        return userRepository.existsById(id);
    }

    public Users readUserInformation(long id) throws TrackerException {
        return userRepository.findById(id).orElse(new Users());
    }


    public Users readUserInformationByEmail(String emailId) {
        return userRepository.findByEmailId(emailId);
    }
}
