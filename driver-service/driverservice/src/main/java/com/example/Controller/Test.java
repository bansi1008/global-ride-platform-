package com.example.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.DTO.Message;
import org.springframework.security.core.Authentication;
import com.example.Config.Security;

@RestController
@RequestMapping("/api/test")


public class Test {

  

    @GetMapping("/hello")
    public String testuser(Authentication authentication) {
       if (authentication == null) {
            return "No authentication found.";
        }
         Object principal = authentication.getPrincipal();

        return "Authenticated userId: " + principal;
    }
        
    
  

   
    
}
