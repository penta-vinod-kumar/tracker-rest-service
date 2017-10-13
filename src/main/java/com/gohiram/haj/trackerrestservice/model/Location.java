package com.gohiram.haj.trackerrestservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "Locations")
@Entity(name="location")
@NoArgsConstructor
@Getter
@Setter
public class Location {

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private String id;

	private String location;

	private Date lastUpdated;




}
