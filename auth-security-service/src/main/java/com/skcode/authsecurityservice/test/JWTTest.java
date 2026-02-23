package com.skcode.authsecurityservice.test;

import com.skcode.authsecurityservice.util.JWTUtil;

import static java.lang.IO.println;

public class JWTTest {
    void main() {
        // Step 1: Generate a token
        String token = JWTUtil.generateToken(
                "alan@example.com",
                "123",
                "456",
                "Retail",
                "IN");
        println("Generated Token:\n" + token);

    }
}
