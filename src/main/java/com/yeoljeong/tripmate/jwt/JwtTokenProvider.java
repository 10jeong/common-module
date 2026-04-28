package com.yeoljeong.tripmate.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import javax.crypto.SecretKey;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class JwtTokenProvider {

    @Value("${jwt.secret}")
    private String secretKey;
    private SecretKey signingKey;
    @Value("${jwt.access-token-expiration}")
    private long accessTokenExpiration;
    @Value("${jwt.refresh-token-expiration}")
    private long refreshTokenExpiration;

    @PostConstruct
    public void init() {
        this.signingKey = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
    }

    public String generateAccessToken(String userId, String role) {
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + accessTokenExpiration);

        return Jwts.builder()
            .subject(userId)
            .issuer("tripMate")
            .claim("role", role)
            .issuedAt(now)
            .expiration(expirationDate)
            .signWith(signingKey)
            .compact();
    }

    public String generateRefreshToken(String userId) {
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + refreshTokenExpiration);

        return Jwts.builder()
            .subject(userId)
            .issuer("tripMate")
            .issuedAt(now)
            .expiration(expirationDate)
            .signWith(signingKey)
            .compact();
    }
}
