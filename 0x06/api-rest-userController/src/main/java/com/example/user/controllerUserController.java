package com.example.user;

import com.example.user.exception.CPFException;
import com.example.user.exception.UserIdException;
import com.example.user.exception.UserNameException;
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

    @GetMapping("/user-name/{username}")
    public String findUserByUserName(@PathVariable String username) {
        if (username != null && username.length() > 3 && username.length() < 15) {
            return "You have entered a valid USERNAME";
        }
        throw new UserNameException(username);
    }

    @GetMapping("/user-cpf/{cpf}")
    public String findUserByCPF(@PathVariable String cpf) {
        if (isCPF(cpf)) {
            return "You have entered a valid CPF";
        }
        throw new CPFException(cpf);
    }

    public boolean isCPF(String cpf) {
        return cpf != null && cpf.length() > 3 && cpf.length() < 15;
    }
}
