package com.eventspot.bookingservice.util;

import java.util.List;
import java.util.stream.Collectors;
import com.eventspot.bookingservice.model.Booking;
import com.eventspot.bookingservice.model.BookingDTO;

public class DTOConverter {
    
    public static BookingDTO convertToDTO(Booking booking) {
      BookingDTO dto = new BookingDTO();
        dto.setId(booking.getId());
        dto.setEventId(booking.getEventId());
        dto.setUserId(booking.getUserId());
        dto.setBookingDate(booking.getBookingDate());
        dto.setBookingStatus(booking.getBookingStatus());
        dto.setTicketCount(booking.getTicketCount());
        dto.setTotalPrice(booking.getTotalPrice());
      return dto;
    }
    
    public static Booking convertToEntity(BookingDTO dto) {
      Booking booking = new Booking();
        booking.setId(dto.getId());  // Assuming we have an ID field that might be null for new entities
        booking.setEventId(dto.getEventId());
        booking.setUserId(dto.getUserId());
        booking.setBookingDate(dto.getBookingDate());
        booking.setBookingStatus(dto.getBookingStatus());
        booking.setTicketCount(dto.getTicketCount());
        booking.setTotalPrice(dto.getTotalPrice());
      return booking;
    }
    
    public static List<BookingDTO> convertListToDTO(List<Booking> bookings) {
        return bookings.stream().map(DTOConverter::convertToDTO).collect(Collectors.toList());
    }
      
}
