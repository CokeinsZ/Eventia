package com.eventia.serverback.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;

import java.security.Key;
import java.util.Date;

public class WebTokenProvider {
    @Value("${jwtSecret}")
    private String jwtSecret = "@zL9C<p+_lR49JlCSz}'30(E0>4w&8$6<4E-PHo0$E<<#XWg'{";

    private Key key;
    private final long validityInMilliseconds = 3600000; // 1 hora

    public WebTokenProvider() {
        this.key = Keys.hmacShaKeyFor(jwtSecret.getBytes());
    }

    public String createToken(String correo, int userId, String role) {
        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);

        return Jwts.builder()
                .setSubject(correo)
                .claim("userId", userId)
                .claim("role", role)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(key)
                .compact();
    }

}
