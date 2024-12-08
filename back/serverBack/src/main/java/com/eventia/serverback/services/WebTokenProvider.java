package com.eventia.serverback.services;

import com.eventia.serverback.config.JwtConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class WebTokenProvider {
    private final Key key;
    private final long validityInMilliseconds;

    public WebTokenProvider(JwtConfig jwtConfig) {
        this.key = jwtConfig.jwtSigningKey();
        this.validityInMilliseconds = jwtConfig.getValidityInMilliseconds();
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

    public Claims validateToken(String token) {
        try {
            return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();

        } catch (ExpiredJwtException e) {
            throw new RuntimeException("Token expirado", e);

        } catch (JwtException e) {
            throw new RuntimeException("Token inválido", e);
        }
    }


}
