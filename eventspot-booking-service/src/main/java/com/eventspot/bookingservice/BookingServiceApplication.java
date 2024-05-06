package com.eventspot.bookingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;
import com.eventspot.bookingservice.config.RestTemplateConfig;

@SpringBootApplication//( scanBasePackages={"com.eventspot.bookingservice.service"})
@EntityScan(basePackages = {"com.eventspot.bookingservice.model"})
@Import(RestTemplateConfig.class)
public class BookingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingServiceApplication.class, args);
	}

}
