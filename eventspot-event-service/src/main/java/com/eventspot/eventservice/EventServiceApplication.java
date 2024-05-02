package com.eventspot.eventservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
 
// exclude={DataSourceAutoConfiguration.class},
@SpringBootApplication//( scanBasePackages={"com.eventspot.eventservice.repository"})
@EntityScan(basePackages = {"com.eventspot.eventservice.model"})
//"com.eventspot.service", "com.eventspot.controller", "com.eventspot.eventservice.model"
public class EventServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventServiceApplication.class, args);
	}

}
