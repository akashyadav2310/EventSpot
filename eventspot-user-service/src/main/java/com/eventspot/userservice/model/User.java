package com.eventspot.userservice.model;

import java.util.Set;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.eventspot.userservice.enums.UserRole;

@Document(collection = "users")
public class User {
    
      @Id
      private String userId;
      
      private String username;
      
      private String password;
      
      private String email;
      
      private Set<UserRole> roles;
      

      public String getUserId() {
        return userId;
      }

      public void setUserId(String userId) {
        this.userId = userId;
      }

      public String getUsername() {
        return username;
      }

      public void setUsername(String username) {
        this.username = username;
      }

      public String getPassword() {
        return password;
      }

      public void setPassword(String password) {
        this.password = password;
      }

      public String getEmail() {
        return email;
      }

      public void setEmail(String email) {
        this.email = email;
      }

      public Set<UserRole> getRoles() {
        return roles;
      }

      public void setRoles(Set<UserRole> roles) {
        this.roles = roles;
      }

}
