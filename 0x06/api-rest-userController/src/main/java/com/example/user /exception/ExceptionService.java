package com.example.user.exception;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class ExceptionService {

    @ExceptionHandler
    public ResponseEntity<UserErrorResponse> handleUserIdException(UserIdException err) {

        UserErrorResponse response = new UserErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                "You have entered ID " + err.getMessage() + " invalid."
        );

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<UserErrorResponse> handleUserNameException(UserNameException err) {

        UserErrorResponse response = new UserErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                "You have entered USERNAME " + err.getMessage() + " invalid."
        );

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<UserErrorResponse> handleCPFException(CPFException err) {

        UserErrorResponse response = new UserErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                "You have entered CPF " + err.getMessage() + " invalid."
        );

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
