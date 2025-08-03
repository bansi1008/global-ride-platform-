package com.ride.Servicelayer;
import com.ride.Model.Signupmodel;
import com.ride.Repository.Signuprepo;


  import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;
    import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class Signuplayer {
 @Autowired
    private Signuprepo signupRepo;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public void signup(Signupmodel signupModel) {
       
        signupRepo.findByEmail(signupModel.getEmail())
                .ifPresent(existingUser -> {
                    throw new RuntimeException("Email already exists");
                });

       
        String encryptedPassword = passwordEncoder.encode(signupModel.getPassword());
        signupModel.setPassword(encryptedPassword);

       
        signupRepo.save(signupModel);


       
    }
    public void login(String email, String password) {
        Signupmodel user = signupRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        
    }
    
}
