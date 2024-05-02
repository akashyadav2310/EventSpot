package com.eventspot.eventservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "events")
public class Event {
    
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long eventId;
     
     @Column(nullable = false)
     private String eventName;
     
     @Column(nullable = false, length = 1000)
     private String eventDescription;
     
     @Column(nullable = false)
     private Date eventDate;
     
     @Column(nullable = false)
     private String location;

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
