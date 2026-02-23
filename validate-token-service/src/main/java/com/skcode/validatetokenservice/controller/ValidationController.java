package com.skcode.validatetokenservice.controller;


import com.skcode.validatetokenservice.util.JWTUtil;
import io.jsonwebtoken.Claims;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class ValidationController {

    @PostMapping("/token")
    public String validateJWTToken(@RequestParam String token) {
        Claims claims = JWTUtil.validateToken(token);
        if (claims != null) {
            System.out.println("Subject (email): " + claims.getSubject());
            System.out.println("User ID: " + claims.get("user_id"));
            System.out.println("Account ID: " + claims.get("account_id"));
            System.out.println("Business Segment: " + claims.get("business_segment"));
            System.out.println("Country Code: " + claims.get("country_code"));
        }
        return "";
    }

}
