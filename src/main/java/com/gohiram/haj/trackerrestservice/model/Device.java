package com.gohiram.haj.trackerrestservice.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DEVICES")
@Data
public class Device {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "USER_ID")
    private long userId;

}
