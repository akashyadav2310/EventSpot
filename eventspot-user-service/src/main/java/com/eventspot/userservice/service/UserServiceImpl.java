package com.eventspot.userservice.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eventspot.userservice.exception.UserNotFoundException;
import com.eventspot.userservice.model.User;
import com.eventspot.userservice.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;    
  
    @Override
    public List<User> getAllUsers() {
      return userRepository.findAll();
    }

    @Override
    public User getUserById(String id) throws UserNotFoundException {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
    }
    
    @Override
    public User createUser(User user) {
      return userRepository.save(user);
    }

    @Override
    public User updateUser(String id, User user) throws UserNotFoundException {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
          user.setUserId(id);;
          return userRepository.save(user);
        } else {
            throw new UserNotFoundException("User not found with id: " + id);
        }
    }

    @Override
    public boolean deleteUser(String id) throws UserNotFoundException {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            userRepository.deleteById(id);
            return true;
        } else {
            throw new UserNotFoundException("User not found with id: " + id);
        }
    }
    

}
