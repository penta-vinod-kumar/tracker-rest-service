package com.gohiram.haj.trackerrestservice.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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

    @Column(name = "LOCATION", length = 100)
    private String location;

    @Column(name = "LAST_UPDATED")
    private Date lastUpdated;


}
