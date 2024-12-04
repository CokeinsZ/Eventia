package com.eventia.serverback.controllers;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/auth")
public class AutorizacionController {

    @Value("${jwt.super.secret.key}")
    private final String llaveSuperSecreta;

    @PostMapping("/generate-token")
    public String generateToken(@RequestParam String username) {
        // Crear el token
        String token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 1000)) // 1 hora de validez
                .signWith(Keys.hmacShaKeyFor(llaveSuperSecreta.getBytes()))
                .compact();
        return token;
    }

    @PostMapping("/validate-token")
    public String validateToken(@RequestParam String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(Keys.hmacShaKeyFor(llaveSuperSecreta.getBytes()))
                    .build()
                    .parseClaimsJws(token); // Si no lanza excepción, el token es válido
            return "Token is valid!";
        } catch (JwtException e) {
            return "Invalid token: " + e.getMessage();
        }
    }




}
