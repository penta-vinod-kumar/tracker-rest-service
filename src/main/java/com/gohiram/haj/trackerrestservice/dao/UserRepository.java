package com.gohiram.haj.trackerrestservice.dao;

import com.gohiram.haj.trackerrestservice.dao.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    Users findByMobileNumber(long mobileNumber);
    Users findByEmailId(String emailId);
}
