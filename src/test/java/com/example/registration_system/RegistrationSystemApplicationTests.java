package com.example.registration_system;

import com.example.registration_system.user.User;
import com.example.registration_system.user.userRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RegistrationSystemApplicationTests {
    private userRepository repo;

    @Test
    void FindByEmail() {
        String email = "cswit997@gmail.com";
        User user = repo.findByEmail(email);
        
    }

}
