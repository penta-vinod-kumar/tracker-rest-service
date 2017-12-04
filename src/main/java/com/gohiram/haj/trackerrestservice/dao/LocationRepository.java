package com.gohiram.haj.trackerrestservice.dao;

import com.gohiram.haj.trackerrestservice.dao.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

}
