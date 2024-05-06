package com.eventspot.eventservice.util;

import java.util.List;
import java.util.stream.Collectors;
import com.eventspot.eventservice.model.Event;
import com.eventspot.eventservice.model.EventDTO;

public class DTOConverter {
    
    public static EventDTO convertToDTO(Event event) {
      EventDTO dto = new EventDTO();
        dto.setEventId(event.getEventId());
        dto.setEventName(event.getEventName());
        dto.setEventDescription(event.getEventDescription());
        dto.setEventDate(event.getEventDate());
        dto.setLocation(event.getLocation());
      return dto;
    }
    
    public static Event convertToEntity(EventDTO dto) {
      Event event = new Event();
        event.setEventId(dto.getEventId());
        event.setEventName(dto.getEventName());
        event.setEventDescription(dto.getEventDescription());
        event.setEventDate(dto.getEventDate());
        event.setLocation(dto.getLocation());
      return event;
    }
    
    public static List<EventDTO> convertListToDTO(List<Event> events) {
        return events.stream().map(DTOConverter::convertToDTO).collect(Collectors.toList());
    }
      
}
