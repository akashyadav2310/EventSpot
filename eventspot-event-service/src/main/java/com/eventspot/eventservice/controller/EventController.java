package com.eventspot.eventservice.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.eventspot.eventservice.exception.ResourceNotFoundException;
import com.eventspot.eventservice.model.Event;
import com.eventspot.eventservice.model.EventDTO;
import com.eventspot.eventservice.service.EventService;
import com.eventspot.eventservice.util.DTOConverter;

@RestController
@RequestMapping("/api/event")
public class EventController {
      
    @Autowired
    private EventService eventService;
  
    @GetMapping("/hello")
    public String hello(){
      System.out.println("ABC.......");
      return "Hello ! Welcome to Event Service..." ;
    }
    
    @GetMapping
    public List<EventDTO> getAllEvents(){
      List<Event> listOfEvents = eventService.getAllEvents();
      return DTOConverter.convertListToDTO(listOfEvents);   // Convert Events to EventDTO's
    }
    
    @GetMapping("/{eventId}")
    public EventDTO getEvent(@PathVariable Long eventId){
      Event event = eventService.getEvent(eventId);
      return DTOConverter.convertToDTO(event);   // Convert Event to EventDTO
    }

    @PostMapping
    public EventDTO createEvent(@RequestBody EventDTO eventDTO) {
        Event event = eventService.createEvent(DTOConverter.convertToEntity(eventDTO)); // Convert EventDTO to Event
        return DTOConverter.convertToDTO(event); // Convert Event to EventDTO
    }
    
    @PutMapping("/{eventId}")
    public EventDTO updateEvent(@PathVariable Long eventId, @RequestBody EventDTO eventDTO) throws ResourceNotFoundException {
      Event event = eventService.updateEvent(eventId, DTOConverter.convertToEntity(eventDTO)); // Convert EventDTO to Event
      return DTOConverter.convertToDTO(event); // Convert Event to EventDTO
    } 
    
    @DeleteMapping("/{eventId}")
    public void deleteEvent(@PathVariable Long eventId) throws ResourceNotFoundException {
      eventService.deleteEvent(eventId);
    }
    
}
