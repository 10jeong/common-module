package com.yeoljeong.tripmate.auth.passport;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;

public class PassportValidator {

    private final SecretKey internalSecretKey;

    public PassportValidator(String base64Secret) {
        byte[] keyBytes = Decoders.BASE64.decode(base64Secret);
        this.internalSecretKey = Keys.hmacShaKeyFor(keyBytes);
    }

    public Claims validate(String passport) {
        return Jwts.parser()
            .verifyWith(internalSecretKey)
            .build()
            .parseSignedClaims(passport)
            .getPayload();
    }

}
