package com.ride.Controller;
import com.ride.DTO.SignupDto;
import com.ride.DTO.LoginDTO;
import com.ride.DTO.MessageDTO;
import com.ride.Model.Signupmodel;
import com.ride.Servicelayer.Signuplayer;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;



@RestController
@RequestMapping("/api")



public class Signupcon {

    @Autowired
    private Signuplayer signuplayer;

    @PostMapping("/signup")
    public MessageDTO signup(@Valid @RequestBody  SignupDto signupDto) {
        
        Signupmodel signupModel = Signupmodel.builder()
                .email(signupDto.getEmail())
                .password(signupDto.getPassword())
                .name(signupDto.getName())
                .phone(signupDto.getPhone())
                .role(signupDto.getRole())
                .build();

       
        signuplayer.signup(signupModel);

        return  new MessageDTO("User registered successfully");
    }

    @PostMapping("/login")
    public MessageDTO login(@Valid @RequestBody LoginDTO loginDTO) {
     signuplayer.login(loginDTO.getEmail(), loginDTO.getPassword());
        return new MessageDTO("Login successful");  }

    
}
