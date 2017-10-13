package com.gohiram.haj.trackerrestservice.model;

import com.gohiram.haj.trackerrestservice.exception.ErrorInformation;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@ApiModel
@NoArgsConstructor
@Getter
@Setter
public class TrackerResponse<T> {

	private ErrorInformation errorInformation;
	private T data;

	public TrackerResponse<T> setErrorInformation(ErrorInformation errorInformation) {
		this.errorInformation = errorInformation;
		return this;
	}

	public TrackerResponse<T> setData(T data) {
		this.data = data;
		return this;
	}
	
	
}
