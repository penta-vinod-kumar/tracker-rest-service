package com.gohiram.haj.trackerrestservice.service.impl;

import com.gohiram.haj.trackerrestservice.dao.FriendsRepository;
import com.gohiram.haj.trackerrestservice.dao.LocationRepository;
import com.gohiram.haj.trackerrestservice.dao.UserRepository;
import com.gohiram.haj.trackerrestservice.dao.model.UserInformation;
import com.gohiram.haj.trackerrestservice.dao.model.Users;
import com.gohiram.haj.trackerrestservice.exception.TrackerException;
import com.gohiram.haj.trackerrestservice.model.UserInformationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserRegistrationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FriendsRepository friendsRepository;

    @Autowired
    private LocationRepository locationRepository;

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

    public List<Users> readAllFriendsUserInformation(Long id) {
        return friendsRepository.findAllByMyId(id).stream().map(friend -> userRepository.findById(friend.getFriendId()).get()).collect(Collectors.toList());
    }

    public UserInformationResponse readEverythingUserInformation(Long id) {
        UserInformationResponse response = new UserInformationResponse();
        Users user = userRepository.findById(id).orElse(null);
        if (user != null) {
            response.setProfile(user);
            // response.setLocation(locationRepository.findById(id).get());
            friendsRepository.findAllByMyId(id).stream().forEach(friend -> {
                response.getFriends().add(userRepository.findById(friend.getFriendId()).get());
                response.getFriendsLocations().add(locationRepository.findById(friend.getFriendId()).get());
            });
        }
        return response;
    }
}
