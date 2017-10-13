package com.gohiram.haj.trackerrestservice.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.gohiram.haj.trackerrestservice.dao.ILocationDao;
import com.gohiram.haj.trackerrestservice.exception.TrackerException;


@Repository
public class LocationDao implements ILocationDao {

	@Value("${sql.insert.location.by.id}")
	private String insertLocationById;
	
	
	@Value("${sql.select.location.by.id}")
	private String selectLocationById;
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public boolean addLocation(String id, String location) throws TrackerException {
		
		try
		{
			return jdbcTemplate.update(insertLocationById,new PreparedStatementSetter() {
				
				@Override
				public void setValues(PreparedStatement statement) throws SQLException {
					
					statement.setString(1, id);
					statement.setString(2, location);
				}
			})>0;
		}
		catch(Exception e)
		{
			throw new TrackerException(e);
		}
	}

	@Override
	public List<String> getRecentLocations(String id) throws TrackerException{
		
		return null;
	}

	@Override
	public String getRecentLocation(String id) throws TrackerException{
		try
		{
			
			return jdbcTemplate.queryForList(selectLocationById, new Object[]{id}, String.class).stream().findFirst().orElse(null);
		}
		catch(Exception e)
		{
			throw new TrackerException(e);
		}
		
	}

}
