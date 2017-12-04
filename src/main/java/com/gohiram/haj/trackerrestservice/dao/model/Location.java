package com.gohiram.haj.trackerrestservice.dao.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "LOCATIONS")
@Entity
@Data
public class Location implements Serializable {

    private static final long serialVersionUID = 1;

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "LAT", length = 100)
    private String lat;

    @Column(name = "LAN", length = 100)
    private String lan;

    @Column(name = "LAST_UPDATED")
    private Date lastUpdated;


}
