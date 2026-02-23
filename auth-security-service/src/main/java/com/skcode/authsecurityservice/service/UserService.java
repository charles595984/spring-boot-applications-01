package com.skcode.authsecurityservice.service;

import com.skcode.authsecurityservice.dto.AuthRequestDTO;
import com.skcode.authsecurityservice.entity.User;
import com.skcode.authsecurityservice.exception.UserNotFoundException;
import com.skcode.authsecurityservice.repo.UserRepository;
import com.skcode.authsecurityservice.util.JWTUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

import static java.lang.IO.println;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(User user) {
        User saveUser = new User();
        saveUser.setUsername(user.getUsername());
        saveUser.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(saveUser);
    }

    public String login(AuthRequestDTO authRequest, Map<String, String> headers) {
        IO.println("login service-method is called");
        User user = userRepository.findByUsername(authRequest.getUsername());
        if(user != null) {
            if (authRequest.getUsername() != null
                    && authRequest.getPassword() != null
                    && headers.get("userId") != null
                    && headers.get("accountId") != null
                    && headers.get("businessSegment") != null
                    && headers.get("countryCode") != null
            ) {
                if (authRequest.getUsername().equals(user.getUsername()) && passwordEncoder.matches(authRequest.getPassword(), user.getPassword())) {
                    return JWTUtil.generateToken(
                            authRequest.getUsername(),
                            headers.get("userId"),
                            headers.get("accountId"),
                            headers.get("businessSegment"),
                            headers.get("countryCode")
                            );
                }
            }
            return user.getUsername();
        } else {
            throw new UserNotFoundException("User not found");
        }

    }
}
