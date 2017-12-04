package com.gohiram.haj.trackerrestservice.dao;

import com.gohiram.haj.trackerrestservice.dao.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Device, String>{

    List<Device> findAllByUserId(@Param("userId") long userId);
}
