package com.gohiram.haj.trackerrestservice.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class AppConfig {

	@Value("${db.url}")
	private String url;

	@Value("${db.username}")
	private String username;

	@Value("${db.password}")
	private String password;

	@Value("${db.driverclassname}")
	private String driverClassName;

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName(driverClassName);
		datasource.setUrl(url);
		datasource.setUsername(username);
		datasource.setPassword(password);
		return datasource;
	}

	@Bean
	@Autowired
	public JdbcTemplate getJdbcTemplate(DataSource datasource) {
		return new JdbcTemplate(datasource);
	}

}
