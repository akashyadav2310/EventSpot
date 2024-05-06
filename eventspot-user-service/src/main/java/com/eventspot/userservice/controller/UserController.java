package com.eventspot.userservice.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eventspot.userservice.exception.UserNotFoundException;
import com.eventspot.userservice.model.User;
import com.eventspot.userservice.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

      @Autowired
      private UserService userService;
  
      @GetMapping("/hello")
      public String welcome() {
        System.out.println("In User Service..............");
        return "Hello ! Welcome to User Service...!" ;
      }
      
      @GetMapping
      public ResponseEntity<List<User>> getAllUsers() {
          List<User> users = userService.getAllUsers();
          return new ResponseEntity<>(users, HttpStatus.OK);
      }
      
      @GetMapping("/{id}")
      public ResponseEntity<User> getUserById(@PathVariable String id) throws UserNotFoundException{
          try {
              User user = userService.getUserById(id);
              return ResponseEntity.ok(user);
          } catch (UserNotFoundException ex) {
              return ResponseEntity.notFound().build();
          }
      }
      
      @PostMapping
      public ResponseEntity<User> createUser(@RequestBody User user) {
          User createdUser = userService.createUser(user);
          return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
      }
      
      @PutMapping("{id}")
      public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User user) throws UserNotFoundException {
            try {
                User updatedUser = userService.updateUser(id, user);
                return new ResponseEntity<>(updatedUser, HttpStatus.OK);
            } catch (UserNotFoundException ex) {
                return ResponseEntity.notFound().build();
            }
      }
      
      @DeleteMapping("{id}")
      public ResponseEntity<Boolean> deleteUser(@PathVariable String id)throws UserNotFoundException {
            try {
                boolean deleted = userService.deleteUser(id);
                return ResponseEntity.ok(deleted);
            } catch (UserNotFoundException ex) {
                return ResponseEntity.notFound().build();
            }
      }
      
}
