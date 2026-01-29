package com.example.user.excaption;

public class UserIdException extends RuntimeException {
  public UserIdException(String message) {
    super(message);
  }
}
