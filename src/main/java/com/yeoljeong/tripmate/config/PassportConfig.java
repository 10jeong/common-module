package com.yeoljeong.tripmate.config;

import com.yeoljeong.tripmate.auth.passport.PassportValidator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PassportConfig {

    @Bean
    public PassportValidator passportValidator(
        @Value("${jwt.internal-secret}") String internalSecret) {
        return new PassportValidator(internalSecret);
    }
}
