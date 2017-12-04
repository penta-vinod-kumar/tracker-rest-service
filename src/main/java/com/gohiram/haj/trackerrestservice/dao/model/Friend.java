package com.gohiram.haj.trackerrestservice.dao.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "FRIENDS")
@Data
public class Friend {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "MY_ID")
	private long myId;

	@Column(name = "FRIEND_ID")
	private long friendId;

	@Column(name = "STATUS", columnDefinition = "default 'PENDING'")
	private String status;

	@Column(name = "LAST_UPDATED")
	private Date lastUpdated;

	@Column(name = "CREATED_ON")
	private Date createdOn;
}
