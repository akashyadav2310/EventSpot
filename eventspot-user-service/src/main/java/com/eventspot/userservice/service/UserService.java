package com.eventspot.userservice.service;

import java.util.List;
import org.springframework.stereotype.Component;
import com.eventspot.userservice.exception.UserNotFoundException;
import com.eventspot.userservice.model.User;

@Component
public interface UserService {

    public List<User> getAllUsers();
  
    public User getUserById(String id) throws UserNotFoundException;
    
    public User createUser(User user);
    
    public User updateUser(String id, User user) throws UserNotFoundException;
    
    public boolean deleteUser(String id) throws UserNotFoundException;
}
