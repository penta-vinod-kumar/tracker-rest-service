package com.gohiram.haj.trackerrestservice.dao.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;

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
