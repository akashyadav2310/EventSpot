package com.eventspot.bookingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication//( scanBasePackages={"com.eventspot.bookingservice.service"})
@EntityScan(basePackages = {"com.eventspot.bookingservice.model"})
public class BookingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingServiceApplication.class, args);
	}

}
