package com.eventspot.bookingservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/booking")
public class BookingController {
  
  @GetMapping("/hello")
  public String getEvent(){
    System.out.println("ABC.......");
    return "Hello ! Welcome to Booking Service..." ;
  }

}
