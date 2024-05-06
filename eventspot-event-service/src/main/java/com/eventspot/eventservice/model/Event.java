package com.eventspot.eventservice.model;

import jakarta.persistence.Entity;
import lombok.Data;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "events")
public class Event {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;
  
    @Column(name = "event_name", nullable = false)
    private String eventName;
  
    @Column(name = "event_description", nullable = false, length = 1000)
    private String eventDescription;
  
    @Column(name = "event_date", nullable = false)
    private Date eventDate;
  
    @Column(name = "location", nullable = false)
    private String location;

    public Event() {
      
    }
    
    public Event(Long eventId, String eventName, String eventDescription, Date eventDate,
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

