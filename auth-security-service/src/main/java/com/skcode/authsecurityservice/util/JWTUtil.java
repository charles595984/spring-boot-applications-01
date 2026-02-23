package com.skcode.authsecurityservice.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTUtil {

    public static final String SECRET_KEY = "5367566859703373367639792F423F452848284D6251655468576D5A71347437";

    public static String generateToken(String username, String userId, String accountId, String businessSegment, String countryCode) { // Use email as username
        Map<String, Object> claims = new HashMap<>();
        claims.put("user_id", userId);
        claims.put("account_id", accountId);
        claims.put("business_segment", businessSegment);
        claims.put("country_code", countryCode);
        IO.println("Claims:: " + claims);
        return createToken(claims, username);
    }

    private static String createToken(Map<String, Object> claims, String email) {
        return Jwts.builder()
                .claims(claims)
                .subject(email)
                .issuer("AuthSecurityService")
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30))
                .signWith(getSignKey())
                .compact();
    }

    private static SecretKey getSignKey(){
        byte[] decodedKey = Base64.getDecoder().decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(decodedKey);
    }


}
