package com.example.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @GetMapping("/user-id/{id}")
    public String findUserById(@PathVariable int id) {
        if (id > 0 && id < 100) return "You have entered a valid ID";
        return "You have entered an invalid ID.";
    }

    @GetMapping("/user-name/{username}")
    public String findUserByUserName(@PathVariable String username) {
        if (username != null && username.length() > 3 && username.length() < 15)
            return "You have entered a valid USERNAME";
        return "You have entered an invalid USERNAME.";
    }

    @GetMapping("/user-cpf/{cpf}")
    public String findUserByCPF(@PathVariable String cpf) {
        if (cpf != null && cpf.length() > 3 && cpf.length() < 15)
            return "You have entered a valid CPF";
        return "You have entered an invalid CPF.";
    }
}
