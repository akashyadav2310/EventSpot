package com.eventspot.eventservice.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.eventspot.eventservice.exception.ResourceNotFoundException;
import com.eventspot.eventservice.model.Event;
import com.eventspot.eventservice.service.EventService;

@RestController
@RequestMapping("api/events")
public class EventController {
    
    @Autowired
    private EventService eventService;
    
    @GetMapping
    public List<Event> getAllEvents(){
      return eventService.getAllEvents() ;
    }
    
    @GetMapping("/{eventId}")
    public Event getEvent(@PathVariable Long eventId){
      return eventService.getEvent(eventId) ;
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
    
}
