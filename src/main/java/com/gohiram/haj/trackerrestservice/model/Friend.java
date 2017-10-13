package com.gohiram.haj.trackerrestservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Friends")
@Table(name = "Friends")
@Getter
@Setter
@NoArgsConstructor
public class Friend {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int generatedId;

	private long id;

	private long friendId;



	public Friend(long id, long friendId, String status) {
		this.id = id;
		this.friendId = friendId;
		this.status = status;
	}

	@Column(name = "status", columnDefinition = "default 'PENDING'")
	private String status;


}
