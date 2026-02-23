package com.skcode.authsecurityservice.controller;

import com.skcode.authsecurityservice.dto.AuthRequestDTO;
import com.skcode.authsecurityservice.entity.User;
import com.skcode.authsecurityservice.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static java.lang.IO.println;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        userService.registerUser(user);
        return "User registered successfully!";
    }

    @PostMapping("/generateToken")
    public String login(@RequestBody AuthRequestDTO authRequest, @RequestHeader Map<String, String> headers) {
        return userService.login(authRequest, headers);
    }

}
