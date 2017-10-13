package com.gohiram.haj.trackerrestservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Devices")
@Getter
@Setter
@NoArgsConstructor
public class Device {

    @Id
    String id;

    long userId;


    public Device(String id, long userId)
    {
        this.id=id;
        this.userId=userId;
    }

}
