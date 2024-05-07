package com.eventspot.bookingservice.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.eventspot.bookingservice.model.Booking;
import com.eventspot.bookingservice.repository.BookingRepository;
import com.eventspot.bookingservice.DTO.EventDTO;
import com.eventspot.bookingservice.DTO.UserDTO;
import com.eventspot.bookingservice.exception.EventNotFoundException;
import com.eventspot.bookingservice.exception.ResourceNotFoundException;
import com.eventspot.bookingservice.exception.UserNotFoundException;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingRepository bookingRepo;
  
    private final RestTemplate restTemplate;

    @Autowired
    public BookingServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    
    @Override
    public List<Booking> getAllBookings() {
      return bookingRepo.findAll();
    }
  
    @Override
    public Booking getBooking(Long bookingId) throws ResourceNotFoundException {
      return bookingRepo.findById(bookingId).orElseThrow( () -> new ResourceNotFoundException (("Booking not found with id: " + bookingId)) );
      //return bookingRepo.getById(bookingId);
    }

    @Override
    public Booking createBooking(Booking booking) throws UserNotFoundException, EventNotFoundException {
      
      UserDTO user = restTemplate.getForObject("http://localhost:8088/api/user/{userId}", UserDTO.class, booking.getUserId());
      if (user == null) {
          throw new UserNotFoundException("User not found with ID: " + booking.getUserId());
      }

      // Validate event ID by calling Event Service API
      EventDTO event = restTemplate.getForObject("http://localhost:8080/api/event/{eventId}", EventDTO.class, booking.getEventId());
      if (event == null) {
          throw new EventNotFoundException("Event not found with ID: " + booking.getEventId());
      }
      
      return bookingRepo.save(booking);
    }

    @Override
    public Booking updateBooking(Long bookingId, Booking booking) throws UserNotFoundException, EventNotFoundException, ResourceNotFoundException {
      Booking existingBooking = bookingRepo.findById(bookingId).orElseThrow( () -> new ResourceNotFoundException (("Booking not found with id: " + bookingId)) );

      // Validate user ID by calling User Service API
      UserDTO user = restTemplate.getForObject("http://localhost:8088/api/user/{userId}", UserDTO.class, booking.getUserId());
      if (user == null) {
          throw new UserNotFoundException("User not found with ID: " + booking.getUserId());
      }

      // Validate event ID by calling Event Service API
      EventDTO event = restTemplate.getForObject("http://localhost:8080/api/event/{eventId}", EventDTO.class, booking.getEventId());
      if (event == null) {
          throw new EventNotFoundException("Event not found with ID: " + booking.getEventId());
      }
      
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
