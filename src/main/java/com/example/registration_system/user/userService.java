package com.example.registration_system.user;

import com.example.registration_system.user.User;
import com.example.registration_system.user.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userService {
    private userRepository userRepository;

    @Autowired
    public userService(userRepository userRepository){
        this.userRepository = userRepository;
    }
    public User registerUser(User user){
        return this.userRepository.save(user);
    }
    public List<User> findAllUsers(){
        return userRepository.findAll();
    }
}
