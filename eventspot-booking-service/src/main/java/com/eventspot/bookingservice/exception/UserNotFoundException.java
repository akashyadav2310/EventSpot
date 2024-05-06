package com.eventspot.bookingservice.exception;

public class UserNotFoundException extends Exception{
  
    public UserNotFoundException(String message) {
        super(message);
    }
}
