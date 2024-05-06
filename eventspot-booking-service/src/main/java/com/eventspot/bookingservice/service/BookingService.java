package com.eventspot.bookingservice.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.eventspot.bookingservice.exception.ResourceNotFoundException;
import com.eventspot.bookingservice.model.Booking;

@Service
public interface BookingService {

    public List<Booking> getAllBookings();
  
    public Booking getBooking(Long bookingId);
  
    public Booking createBooking(Booking booking);
    
    public Booking updateBooking(Long bookingId, Booking booking) throws ResourceNotFoundException;
    
    public boolean deleteBooking(Long bookingId);
    
}
