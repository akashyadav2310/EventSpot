package com.eventspot.eventservice.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.eventspot.eventservice.exception.ResourceNotFoundException;
import com.eventspot.eventservice.model.Event;
import com.eventspot.eventservice.model.EventDTO;
import com.eventspot.eventservice.service.EventService;

@RestController
@RequestMapping("/api/event")
public class EventController {
  
//
//@RestController
//@RequestMapping("/api/events")
//public class EventController {
//    
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
      return convertToDTO(listOfEvents);
      //return eventService.getAllEvents() ;
    }
    
    @GetMapping("/{eventId}")
    public EventDTO getEvent(@PathVariable Long eventId){
      Event event = eventService.getEvent(eventId);
      return convertToDTO(event);
    }

    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        return eventService.createEvent(event);
    }
    
    @PutMapping("/{eventId}")
    public Event updateEvent(@PathVariable Long eventId, @RequestBody Event event) throws ResourceNotFoundException {
        return eventService.updateEvent(eventId, event);
    } 
    
    @DeleteMapping("/{eventId}")
    public void deleteEvent(@PathVariable Long eventId) throws ResourceNotFoundException {
      eventService.deleteEvent(eventId);
    }
    
    public static EventDTO convertToDTO(Event event) {
        EventDTO dto = new EventDTO();
        dto.setEventId(event.getEventId());
        dto.setEventName(event.getEventName());
        dto.setEventDescription(event.getEventDescription());
        dto.setEventDate(event.getEventDate());
        dto.setLocation(event.getLocation());
        return dto;
    }
    
    public static List<EventDTO> convertToDTO(List<Event> events) {
        return events.stream().map(EventController::convertToDTO).collect(Collectors.toList());
    }
    
}
