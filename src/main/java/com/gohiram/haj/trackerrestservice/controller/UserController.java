package com.gohiram.haj.trackerrestservice.controller;

import com.gohiram.haj.trackerrestservice.exception.TrackerException;
import com.gohiram.haj.trackerrestservice.dao.model.TrackerRequest;
import com.gohiram.haj.trackerrestservice.dao.model.TrackerResponse;
import com.gohiram.haj.trackerrestservice.dao.model.UserInformation;
import com.gohiram.haj.trackerrestservice.dao.model.Users;
import com.gohiram.haj.trackerrestservice.model.UserInformationResponse;
import com.gohiram.haj.trackerrestservice.service.impl.UserRegistrationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Api(value = "UserRegistrationService")
//@CrossOrigin
@RestController

@RequestMapping("/user-details")
public class UserController {

    @Autowired
    private UserRegistrationService userRegistrationService;

    @ApiOperation(consumes = "application/json", value = "/register", httpMethod = "POST", produces = "application/json", response = TrackerResponse.class)
    @RequestMapping(path = "register", method = RequestMethod.POST)
    public ResponseEntity<TrackerResponse<Users>> registerUser(@RequestBody() TrackerRequest<UserInformation> request) throws TrackerException {
        TrackerResponse<Users> response = new TrackerResponse<>();
        response.setData(userRegistrationService.registerUser(request.getData()));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @ApiOperation(consumes = "application/json", value = "/read/{id}", httpMethod = "GET", produces = "application/json", response = TrackerResponse.class)
    @RequestMapping(path = "read/{id}", method = RequestMethod.GET)
    public ResponseEntity<TrackerResponse<Users>> readUser(@PathVariable long id) throws TrackerException {
        TrackerResponse<Users> response = new TrackerResponse<>();
        response.setData(userRegistrationService.readUserInformation(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //@ApiOperation(consumes = "application/json", value = "/read/{id}", httpMethod = "GET", produces = "application/json", response = TrackerResponse.class)
    @RequestMapping(path = "read-by-email/{emailId}/", method = RequestMethod.GET)
    public ResponseEntity<TrackerResponse<Users>> readUserByEmail(@PathVariable String emailId) throws TrackerException {
        TrackerResponse<Users> response = new TrackerResponse<>();
        response.setData(userRegistrationService.readUserInformationByEmail(emailId));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @RequestMapping(path = "is-user-exists/{id}", method = RequestMethod.GET)
    public ResponseEntity<TrackerResponse<Boolean>> isUserExists(@PathVariable Long id) throws TrackerException {
        return new ResponseEntity<>(new TrackerResponse<Boolean>().setData(userRegistrationService.isUserRegistered(id)), HttpStatus.OK);
    }

    @RequestMapping(path = "read-all-friends/{id}", method = RequestMethod.GET)
    public ResponseEntity<TrackerResponse<List<Users>>> readAllFriends(@PathVariable Long id) throws TrackerException {
        return new ResponseEntity<>(new TrackerResponse<List<Users>>().setData(userRegistrationService.readAllFriendsUserInformation(id)), HttpStatus.OK);
    }

    @RequestMapping(path = "read-everything/{id}", method = RequestMethod.GET)
    public ResponseEntity<TrackerResponse<UserInformationResponse>> readEverything(@PathVariable Long id) throws TrackerException {
        return new ResponseEntity<>(new TrackerResponse<UserInformationResponse>().setData(userRegistrationService.readEverythingUserInformation(id)), HttpStatus.OK);
    }
}
