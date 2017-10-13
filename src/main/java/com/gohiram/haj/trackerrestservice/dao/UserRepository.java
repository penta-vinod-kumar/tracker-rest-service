package com.gohiram.haj.trackerrestservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gohiram.haj.trackerrestservice.model.UserInformation;

@Repository
public interface UserRepository extends JpaRepository<UserInformation,Long>{

	
}
