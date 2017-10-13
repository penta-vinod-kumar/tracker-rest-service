package com.gohiram.haj.trackerrestservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="Users")
@Table(name="Users")
@ApiModel
@NoArgsConstructor
@Getter
@Setter
public class UserInformation {

	@ApiModelProperty
	private String firstName;
	
	@ApiModelProperty
	private String lastName;
	
	@ApiModelProperty
	private String emailId;
	
	@Id
	@ApiModelProperty
	private long mobileNumber;
	
}
