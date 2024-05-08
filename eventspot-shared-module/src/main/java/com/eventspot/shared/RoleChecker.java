package com.eventspot.shared;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.Collection;

@Component
public class RoleChecker {

    public boolean hasAdminRole(Principal principal) {
      if (principal != null && principal instanceof Authentication) {
          Collection<? extends GrantedAuthority> authorities = ((Authentication) principal).getAuthorities();
          return authorities.stream().anyMatch(auth -> auth.getAuthority().equals("ADMIN"));
      }
      return false;
    }
}
