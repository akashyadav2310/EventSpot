package com.eventspot.eventservice.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eventspot.eventservice.exception.ResourceNotFoundException;
import com.eventspot.eventservice.model.Event;
import com.eventspot.eventservice.repository.EventRepository;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepo; 
    
    @Override
    public List<Event> getAllEvents() {
      return eventRepo.findAll() ;
    }

    @Override
    public Event getEvent(Long eventId) {
      return eventRepo.getById(eventId);
    }

    @Override
    public Event createEvent(Event event) {
      return eventRepo.save(event) ;
    }
    
    @Override
    public Event updateEvent(Long eventId, Event event) throws ResourceNotFoundException{
      
      Event existingEvent = eventRepo.findById(eventId).orElseThrow( () -> new ResourceNotFoundException (("Event not found with id: " + eventId)) );
      
      // Update event details
      existingEvent.setEventName(event.getEventName());
      existingEvent.setEventDescription(event.getEventDescription());
      existingEvent.setEventDate(event.getEventDate());
      existingEvent.setLocation(event.getLocation());
      
      return eventRepo.save(existingEvent);
    }

    @Override
    public void deleteEvent(Long eventId) throws ResourceNotFoundException {
      // Check if event exists
      if (!eventRepo.existsById(eventId)) {
          throw new ResourceNotFoundException("Event not found with id: " + eventId);
      }
       
      eventRepo.deleteById(eventId);
    }
    
}
