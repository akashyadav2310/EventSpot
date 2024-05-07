package com.eventspot.eventservice.service;

import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Component;
import com.eventspot.eventservice.exception.ResourceNotFoundException;
import com.eventspot.eventservice.model.Event;
import com.eventspot.eventservice.model.EventDTO;

@Component
public interface EventService {
    
    public List<Event> getAllEvents();

    public Event getEvent(Long eventId) throws ResourceNotFoundException;
    
    public Event createEvent(Event event);

    public Event updateEvent(Long eventId, Event event) throws ResourceNotFoundException;
    
    public void deleteEvent(Long eventId) throws ResourceNotFoundException;
    
    //public List<Event> searchEvents(String eventName, Date eventDate, String location);
    
}
