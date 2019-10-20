package com.example.demo.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class userNotFoundExcecption extends RuntimeException {
    public userNotFoundExcecption(String message) {
        super(message);
    }
}
