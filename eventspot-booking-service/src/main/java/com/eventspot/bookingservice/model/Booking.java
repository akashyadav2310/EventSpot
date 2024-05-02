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
    
}