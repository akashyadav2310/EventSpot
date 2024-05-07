package com.eventspot.eventservice.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<EventDTO>> getAllEvents(){
        List<Event> listOfEvents = eventService.getAllEvents();
        List<EventDTO> eventDTOs = DTOConverter.convertListToDTO(listOfEvents);   // Convert Events to EventDTO's
        return ResponseEntity.ok().body(eventDTOs);
    }
    
    @GetMapping("/{eventId}")
    public ResponseEntity<EventDTO> getEvent(@PathVariable Long eventId) throws ResourceNotFoundException{
        try {
            Event event = eventService.getEvent(eventId);
            return ResponseEntity.status(HttpStatus.CREATED).body(DTOConverter.convertToDTO(event));
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<EventDTO> createEvent(@RequestBody EventDTO eventDTO) {
        Event event = eventService.createEvent(DTOConverter.convertToEntity(eventDTO)); // Convert EventDTO to Event
        EventDTO createdEventDTO = DTOConverter.convertToDTO(event);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEventDTO);
    }
    
    @PutMapping("/{eventId}")
    public ResponseEntity<EventDTO> updateEvent(@PathVariable Long eventId, @RequestBody EventDTO eventDTO) throws ResourceNotFoundException {
        try {
            Event event = eventService.updateEvent(eventId, DTOConverter.convertToEntity(eventDTO)); // Convert EventDTO to Event
            EventDTO updatedEventDTO = DTOConverter.convertToDTO(event);
            return ResponseEntity.status(HttpStatus.OK).body(updatedEventDTO);
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    } 
    
    @DeleteMapping("/{eventId}")
    public ResponseEntity<?> deleteEvent(@PathVariable Long eventId) throws ResourceNotFoundException {
         try {   
             eventService.deleteEvent(eventId);
             return ResponseEntity.status(HttpStatus.OK).build();
         } catch (ResourceNotFoundException ex) {
             return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
         }
    }
    
//    @GetMapping("/search")
//    public List<EventDTO> searchEvents(@RequestParam(required = false) String eventName,
//                                       @RequestParam(required = false) Date eventDate,
//                                       @RequestParam(required = false) String location) {
//        List<Event> events = eventService.searchEvents(eventName, eventDate, location);
//        return DTOConverter.convertListToDTO(events);
//    }
    
}
