package com.eventspot.bookingservice.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eventspot.bookingservice.exception.ResourceNotFoundException;
import com.eventspot.bookingservice.model.Booking;
import com.eventspot.bookingservice.model.BookingDTO;
import com.eventspot.bookingservice.service.BookingService;
import com.eventspot.bookingservice.util.DTOConverter;

@RestController
@RequestMapping("/api/booking")
public class BookingController {
  
    @Autowired
    private BookingService bookingService; 
  
    @GetMapping("/hello")
    public String getEvent(){
      System.out.println("ABC.......");
      return "Hello ! Welcome to Booking Service..." ;
    }
    
    @GetMapping
    public List<BookingDTO> getAllBookings(){
      List<Booking> listOfBookings = bookingService.getAllBookings();
      return DTOConverter.convertListToDTO(listOfBookings);   // Convert Booking to BookingDTO's
//        return null;
    }
    
    @GetMapping("/{bookingId}")
    public BookingDTO getEvent(@PathVariable Long bookingId){
      Booking booking = bookingService.getBooking(bookingId);
      return DTOConverter.convertToDTO(booking);   // Convert Event to EventDTO
     }

    @PostMapping
    public ResponseEntity<BookingDTO> createBooking(@RequestBody BookingDTO bookingDTO) {
        Booking createdBooking = bookingService.createBooking(DTOConverter.convertToEntity(bookingDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(DTOConverter.convertToDTO(createdBooking));
    }
    
    @PutMapping("/{bookingId}") 
    public ResponseEntity<BookingDTO> updateBooking(@PathVariable Long bookingId, @RequestBody BookingDTO bookingDTO) throws ResourceNotFoundException { 
        Booking updatedBooking = bookingService.updateBooking(bookingId, DTOConverter.convertToEntity(bookingDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(DTOConverter.convertToDTO(updatedBooking));
    }
    
    @DeleteMapping("/{bookingId}") 
    public ResponseEntity<Void> deleteBooking(@PathVariable Long bookingId){
      boolean deleted = bookingService.deleteBooking(bookingId);
      if (deleted) {
        return ResponseEntity.noContent().build();
      } else {
          return ResponseEntity.notFound().build();
      }
    }
    
}