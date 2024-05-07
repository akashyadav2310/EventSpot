package com.eventspot.bookingservice.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.eventspot.bookingservice.exception.EventNotFoundException;
import com.eventspot.bookingservice.exception.ResourceNotFoundException;
import com.eventspot.bookingservice.exception.UserNotFoundException;
import com.eventspot.bookingservice.model.Booking;

@Service
public interface BookingService {

    public List<Booking> getAllBookings();
  
    public Booking getBooking(Long bookingId)  throws ResourceNotFoundException;
  
    public Booking createBooking(Booking booking) throws UserNotFoundException, EventNotFoundException;
    
    public Booking updateBooking(Long bookingId, Booking booking) throws UserNotFoundException, EventNotFoundException, ResourceNotFoundException;
    
    public boolean deleteBooking(Long bookingId);
    
}
