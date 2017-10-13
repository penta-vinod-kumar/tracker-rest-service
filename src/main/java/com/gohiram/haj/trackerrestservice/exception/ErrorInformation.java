package com.gohiram.haj.trackerrestservice.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
@NoArgsConstructor
@Getter
@Setter
public class ErrorInformation {

	@ApiModelProperty(name = "message")
	private String message;

	@ApiModelProperty(name = "statusCode")
	private HttpStatus statusCode;

	@ApiModelProperty(name = "developerMessage")
	private String developerMessage;

}
