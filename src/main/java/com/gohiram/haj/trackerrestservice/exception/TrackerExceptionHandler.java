package com.gohiram.haj.trackerrestservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.gohiram.haj.trackerrestservice.model.TrackerResponse;

import springfox.documentation.annotations.ApiIgnore;

@ControllerAdvice
@RestController
@ApiIgnore
public class TrackerExceptionHandler {

	private static final String ERROR_MESSAGE_INTERNAL_SERVER_ERROR = "Please contact your administrator";

	@ExceptionHandler
	public ResponseEntity<TrackerResponse<String>> throwTrackerResponse(TrackerException e) {

		TrackerResponse<String> response = new TrackerResponse<>();
		ErrorInformation errorInformation = new ErrorInformation();
		errorInformation.setDeveloperMessage(e.getMessage());
		errorInformation.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
		errorInformation.setMessage(ERROR_MESSAGE_INTERNAL_SERVER_ERROR);
		response.setErrorInformation(errorInformation);
		response.setData(ERROR_MESSAGE_INTERNAL_SERVER_ERROR);

		if (e.getStatus() != null) {
			return new ResponseEntity<>(response, e.getStatus());
		} else {
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
