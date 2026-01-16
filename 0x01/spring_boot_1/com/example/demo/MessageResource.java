package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
public class MessageResource {

    @GetMapping("/simpleMessageWelcome")
    public String simpleMessageWelcome() {
        return "WELCOME TO THE MICRO-SERVICE CLASS USING SPRING BOOT!!!";
    }

    @GetMapping("/login")
    public String login(
            @RequestParam(required = false) String user,
            @RequestParam(required = false) String password) {

        if (user == null || password == null || user.isBlank() || password.isBlank()) {
            return "USER AND PASSWORD NOT PROVIDED";
        }

        if (user.length() > 15 || password.length() > 15) {
            return "USER AND PASSWORD INVALID";
        }

        return "LOGIN SUCCESSFUL!!!";
    }
}
