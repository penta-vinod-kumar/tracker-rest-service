package com.gohiram.haj.trackerrestservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gohiram.haj.trackerrestservice.exception.TrackerException;
import com.gohiram.haj.trackerrestservice.model.TrackerRequest;
import com.gohiram.haj.trackerrestservice.model.TrackerResponse;
import com.gohiram.haj.trackerrestservice.model.UserInformation;
import com.gohiram.haj.trackerrestservice.service.ILoginService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(value="LoginService")
@RestController("/user")
public class LoginController {

	@Autowired
	private ILoginService loginService;

	@ApiOperation(consumes = "application/json", value = "/login/status/{id}", httpMethod = "GET", produces = "application/json", response = TrackerResponse.class)
	@RequestMapping(path = "/login/status/{id}", method = RequestMethod.GET)
	public ResponseEntity<TrackerResponse<Boolean>> isUserLoggedIn(@PathVariable String id) throws TrackerException {
		return new ResponseEntity<>(
				new TrackerResponse<Boolean>().setData(Boolean.valueOf(loginService.isLoggedIn(id))), HttpStatus.OK);

	}

	@ApiOperation(consumes = "application/json", value = "/login", httpMethod = "PUT", produces = "application/json", response = TrackerResponse.class)
	@RequestMapping(path = "/login", method = RequestMethod.PUT)
	public ResponseEntity<TrackerResponse<UserInformation>> login(TrackerRequest<UserInformation> request)
			throws TrackerException {
		return new ResponseEntity<>(
				new TrackerResponse<UserInformation>().setData(loginService.login(request.getData())),
				HttpStatus.CREATED);
	}

}
