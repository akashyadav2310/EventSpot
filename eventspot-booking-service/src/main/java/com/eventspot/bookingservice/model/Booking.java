package com.eventspot.bookingservice.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "event_id", nullable = false)
    private Long eventId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "booking_date", nullable = false)
    private Date bookingDate;

    @Column(name = "booking_status", nullable = false)
    private String bookingStatus;

    @Column(name = "ticket_count", nullable = false)
    private int ticketCount;

    @Column(name = "total_price", nullable = false)
    private double totalPrice;

    public Booking() {
      
    }
    
    public Booking(Long id, Long eventId, Long userId, Date bookingDate, String bookingStatus,
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

    public Long getUserId() {
      return userId;
    }

    public void setUserId(Long userId) {
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
