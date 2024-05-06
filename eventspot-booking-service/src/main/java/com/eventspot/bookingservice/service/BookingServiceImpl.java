package com.eventspot.bookingservice.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eventspot.bookingservice.model.Booking;
import com.eventspot.bookingservice.repository.BookingRepository;
import com.eventspot.bookingservice.exception.ResourceNotFoundException;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingRepository bookingRepo;
  
    @Override
    public List<Booking> getAllBookings() {
      bookingRepo.findAll();
      return null;
    }
  
    @Override
    public Booking getBooking(Long bookingId) {
      return bookingRepo.getById(bookingId);
    }

    @Override
    public Booking createBooking(Booking booking) {
      return bookingRepo.save(booking);
    }

    @Override
    public Booking updateBooking(Long bookingId, Booking booking) throws ResourceNotFoundException {
      Booking existingBooking = bookingRepo.findById(bookingId).orElseThrow( () -> new ResourceNotFoundException (("Booking not found with id: " + bookingId)) );

      existingBooking.setEventId(booking.getEventId());
      existingBooking.setUserId(booking.getUserId());
      existingBooking.setBookingDate(booking.getBookingDate());
      existingBooking.setBookingStatus(booking.getBookingStatus());
      existingBooking.setTicketCount(booking.getTicketCount());
      existingBooking.setTotalPrice(booking.getTotalPrice());
      
      return bookingRepo.save(existingBooking);
    }

    @Override
    public boolean deleteBooking(Long bookingId) {
      if(bookingRepo.existsById(bookingId)) {
          bookingRepo.deleteById(bookingId);
          return true;
      }else {
        return false;
      }
    }
    
    
}
