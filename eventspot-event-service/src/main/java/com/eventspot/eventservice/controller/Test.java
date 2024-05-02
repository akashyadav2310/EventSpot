package com.eventspot.eventservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/eventssssss")
public class Test {
  
  @GetMapping("/hello")
  public String getEvent(){
    System.out.println("ABC.......");
    return "[Event Service] Hello ...!" ;
  }

}
