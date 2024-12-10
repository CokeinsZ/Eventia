package com.eventia.serverback.config;

import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.Key;

@Configuration
public class JwtConfig {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.validity}")
    private long validityInMilliseconds;

    @Bean
    public Key jwtSigningKey() {
        return Keys.hmacShaKeyFor(jwtSecret.getBytes());
    }

    public long getValidityInMilliseconds() {
        return validityInMilliseconds;
    }
}
