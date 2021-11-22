package com.example.registration_system.user;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class UserController {

    private final userService userService;

    public UserController(userService userService){
        this.userService = userService;
    }

    @GetMapping("")
    public String viewHomepage(){
        return "index" ;
    }
    @GetMapping("/register")
    public String signupForm(Model model){
        model.addAttribute("user",new User());
        return "signup";

    }
    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userService.registerUser(user);

        return "register_success";
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> listUsers = userService.findAllUsers();
        model.addAttribute("listUsers", listUsers);

        return "users";
    }
}
