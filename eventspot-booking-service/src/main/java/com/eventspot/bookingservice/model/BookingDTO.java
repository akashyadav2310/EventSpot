package com.eventspot.bookingservice.model;

import java.util.Date;

public class BookingDTO {
    
      private Long id;
    
      private Long eventId;
    
      private String userId;
    
      private Date bookingDate;
    
      private String bookingStatus;
    
      private int ticketCount;
    
      private double totalPrice;
    
      public BookingDTO() {
        
      }
      
      public BookingDTO(Long id, Long eventId, String userId, Date bookingDate, String bookingStatus,
          int ticketCount, double totalPrice) {
          this.id = id;
          this.eventId = eventId;
          this.userId = userId;
          this.bookingDate = bookingDate;
          this.bookingStatus = bookingStatus;
          this.ticketCount = ticketCount;
          this.totalPrice = totalPrice;
      }
    
      public Long getId() {
        return id;
      }
    
      public void setId(Long id) {
        this.id = id;
      }
    
      public Long getEventId() {
        return eventId;
      }
    
      public void setEventId(Long eventId) {
        this.eventId = eventId;
      }
    
      public String getUserId() {
        return userId;
      }
    
      public void setUserId(String userId) {
        this.userId = userId;
      }
    
      public Date getBookingDate() {
        return bookingDate;
      }
    
      public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
      }
    
      public String getBookingStatus() {
        return bookingStatus;
      }
    
      public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
      }
    
      public int getTicketCount() {
        return ticketCount;
      }
    
      public void setTicketCount(int ticketCount) {
        this.ticketCount = ticketCount;
      }
    
      public double getTotalPrice() {
        return totalPrice;
      }
    
      public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
      }
      
}
