package com.skcode.validatetokenservice.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTUtil {

    public static final String SECRET_KEY = "5367566859703373367639792F423F452848284D6251655468576D5A71347437";

    private static SecretKey getSignKey() {
        byte[] decodedKey = Base64.getDecoder().decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(decodedKey);
    }

    // ✅ Validate token and return claims if valid
    public static Claims validateToken(String token) {
        try {
            return Jwts
                    .parserBuilder()
                    .setSigningKey(getSignKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            System.out.println("Token expired: " + e.getMessage());
        } catch (UnsupportedJwtException e) {
            System.out.println("Unsupported JWT: " + e.getMessage());
        } catch (MalformedJwtException e) {
            System.out.println("Malformed JWT: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal argument token: " + e.getMessage());
        }
        return null;
    }

//    public static String extractUsername(String token) {
//        return Jwts
//                .parserBuilder()
//                .setSigningKey(getSignKey())
//                .build()
//                .parseClaimsJws(token)
//                .getBody()
//                .getSubject();
//    }

    // ✅ Token generation (same as your code)
    public static String generateToken(String username, String userId, String accountId, String businessSegment, String countryCode) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("user_id", userId);
        claims.put("account_id", accountId);
        claims.put("business_segment", businessSegment);
        claims.put("country_code", countryCode);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuer("AuthSecurityService")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30)) // 30 min expiry
                .signWith(getSignKey())
                .compact();
    }


}
