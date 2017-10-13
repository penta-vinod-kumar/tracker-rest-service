package com.gohiram.haj.trackerrestservice.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gohiram.haj.trackerrestservice.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location,Long>{
	
	@Query("SELECT loc.location FROM location loc where location.id=:id ORDER BY loc.lastUpdated DESC")
	public List<String> findAll(@Param("id") String id, Pageable limit);

	
	@Query("SELECT loc FROM location loc where location.id=:id ORDER BY loc.lastUpdated DESC")
	public List<Location> findAllLocation(@Param("id") String id, Pageable limit);

}
