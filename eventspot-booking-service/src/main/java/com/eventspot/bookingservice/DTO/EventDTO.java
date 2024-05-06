package com.eventspot.bookingservice.DTO;

import java.util.Date;

public class EventDTO {
  
    private Long eventId;
    private String eventName;
    private String eventDescription;
    private Date eventDate;
    private String location;
  
    public EventDTO() {
    }

    public EventDTO(Long eventId, String eventName, String eventDescription, Date eventDate,
        String location) {
      this.eventId = eventId;
      this.eventName = eventName;
      this.eventDescription = eventDescription;
      this.eventDate = eventDate;
      this.location = location;
    }

    public Long getEventId() {
      return eventId;
    }

    public void setEventId(Long eventId) {
      this.eventId = eventId;
    }

    public String getEventName() {
      return eventName;
    }

    public void setEventName(String eventName) {
      this.eventName = eventName;
    }

    public String getEventDescription() {
      return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
      this.eventDescription = eventDescription;
    }

    public Date getEventDate() {
      return eventDate;
    }

    public void setEventDate(Date eventDate) {
      this.eventDate = eventDate;
    }

    public String getLocation() {
      return location;
    }

    public void setLocation(String location) {
      this.location = location;
    }
    
}
