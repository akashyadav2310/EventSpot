package com.eventspot.eventservice.service;

import java.util.List;
import org.springframework.stereotype.Component;
import com.eventspot.eventservice.exception.ResourceNotFoundException;
import com.eventspot.eventservice.model.Event;

@Component
public interface EventService {
    
    public List<Event> getAllEvents();

    public Event createEvent(Event event);

    public Event getEvent(Long eventId);

    public Event updateEvent(Long eventId, Event event) throws ResourceNotFoundException;
    
    public void deleteEvent(Long eventId) throws ResourceNotFoundException;
    
}
