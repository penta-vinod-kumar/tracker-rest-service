package com.gohiram.haj.trackerrestservice.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ApiModel
@Getter
@Setter
@NoArgsConstructor
public class TrackerRequest<T> {

	@ApiModelProperty(name="requestUid")
	private String requestUid;
	
	@ApiModelProperty(name="data")
	private T data;
	
}
