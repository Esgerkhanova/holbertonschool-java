package com.example.user.controller;

import com.example.user.exception.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @GetMapping("/user-id/{id}")
    public String findUserById(@PathVariable int id) {

        if (id > 0 && id < 100) {
            return "You have entered a valid ID";
        }
        throw new UserIdException(String.valueOf(id));
    }

    @GetMapping("/user-name/{userName}")
    public String findUserByName(@PathVariable String userName) {

        if (userName.length() > 3 && userName.length() < 15) {
            return "You have entered a valid USERNAME";
        }
        throw new UserNameException(userName);
    }

    @GetMapping("/user-cpf/{cpf}")
    public String findUserByCPF(@PathVariable String cpf) {

        if (isCPF(cpf)) {
            return "You have entered a valid CPF";
        }
        throw new CPFException(cpf);
    }

    public boolean isCPF(String cpf) {
        return cpf.length() > 3 && cpf.length() < 15;
    }
}
