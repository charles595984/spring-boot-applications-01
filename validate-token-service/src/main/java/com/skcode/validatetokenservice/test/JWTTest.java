package com.skcode.validatetokenservice.test;

import com.skcode.validatetokenservice.util.JWTUtil;
import io.jsonwebtoken.Claims;

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


        // Step 2: Validate the token
        Claims claims = JWTUtil.validateToken(token);
        if (claims != null) {
            println("\n=== Token Claims ===");
            println("Subject (email): " + claims.getSubject());
            println("Issuer: " + claims.getIssuer());
            println("Issued At: " + claims.getIssuedAt());
            println("Expiration: " + claims.getExpiration());
            println("User ID: " + claims.get("user_id"));
            println("Account ID: " + claims.get("account_id"));
            println("Business Segment: " + claims.get("business_segment"));
            println("Country Code: " + claims.get("country_code"));
        } else {
            System.out.println("Token is invalid or expired.");
        }

    }
}
