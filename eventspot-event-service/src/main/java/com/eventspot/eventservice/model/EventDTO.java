package com.eventspot.eventservice.model;

import java.util.Date;
import jakarta.persistence.Column;

public class EventDTO {

    private Long eventId;
  
    private String eventName;
  
    private String eventDescription;
  
    private Date eventDate;
  
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
