package com.gohiram.haj.trackerrestservice.dao;

import com.gohiram.haj.trackerrestservice.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    Users findByMobileNumber(long mobileNumber);
}
