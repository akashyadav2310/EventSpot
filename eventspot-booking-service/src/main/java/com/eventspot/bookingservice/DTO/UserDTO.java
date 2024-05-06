package com.eventspot.bookingservice.DTO;

public class UserDTO {
  
    private String userId;
    private String username;
    private String email;
    private String roles;
  
    public UserDTO(){
    }

    public UserDTO(String userId, String username, String email, String roles) {
      this.userId = userId;
      this.username = username;
      this.email = email;
      this.roles = roles;
    }

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

    public String getEmail() {
      return email;
    }

    public void setEmail(String email) {
      this.email = email;
    }

    public String getRoles() {
      return roles;
    }

    public void setRoles(String roles) {
      this.roles = roles;
    }
    
}
