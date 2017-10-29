package com.gohiram.haj.trackerrestservice.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Users")
@Table(name = "Users")
@ApiModel
@NoArgsConstructor
@Getter
@Setter
public class UserInformation {

    @Id
    private Long id;

    @ApiModelProperty
    private String firstName;

    @ApiModelProperty
    private String lastName;

    @ApiModelProperty
    private String emailId;

    @ApiModelProperty
    private long mobileNumber;

}
