package com.gohiram.haj.trackerrestservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.gohiram.haj.trackerrestservice"})
public class TrackerRestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrackerRestServiceApplication.class, args);
	}
}
