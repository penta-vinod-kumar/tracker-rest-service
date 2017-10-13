package com.gohiram.haj.trackerrestservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gohiram.haj.trackerrestservice.exception.TrackerException;
import com.gohiram.haj.trackerrestservice.model.TrackerRequest;
import com.gohiram.haj.trackerrestservice.model.TrackerResponse;
import com.gohiram.haj.trackerrestservice.model.UserInformation;
import com.gohiram.haj.trackerrestservice.service.IUserRegistrationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(value="UserRegistrationService")
@RestController
@RequestMapping("/user-details")
public class UserController {

	@Autowired
	private IUserRegistrationService userRegistrationService;

	@ApiOperation(consumes = "application/json", value = "/register", httpMethod = "POST", produces = "application/json", response = TrackerResponse.class)
	@RequestMapping(path = "register", method = RequestMethod.POST)
	public ResponseEntity<TrackerResponse<Boolean>> registerUser(@RequestBody() TrackerRequest<UserInformation> request) throws  TrackerException {
		TrackerResponse<Boolean> response = new TrackerResponse<>();
		response.setData(userRegistrationService.registerUser(request.getData()));
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	
	@ApiOperation(consumes = "application/json", value = "/read/{id}", httpMethod = "GET", produces = "application/json", response = TrackerResponse.class)
	@RequestMapping(path="read/{id}",method=RequestMethod.GET)
	public ResponseEntity<TrackerResponse<UserInformation>> readUser(@PathVariable long id) throws TrackerException
	{
		TrackerResponse<UserInformation> response=new TrackerResponse<>(); 
		response.setData(userRegistrationService.readUserInformation(id));
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@RequestMapping(path="is-user-exists/{id}",method=RequestMethod.GET)
	public ResponseEntity<TrackerResponse<Boolean>> isUserExists(@PathVariable Long id) throws TrackerException
	{
		return  new ResponseEntity<>(new TrackerResponse<Boolean>().setData(userRegistrationService.isUserRegistered(id)),HttpStatus.OK);
	}
}
