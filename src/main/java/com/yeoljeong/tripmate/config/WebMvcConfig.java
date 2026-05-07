package com.yeoljeong.tripmate.config;

import com.yeoljeong.tripmate.auth.context.LoginUserArgumentResolver;
import com.yeoljeong.tripmate.auth.context.UserContextInterceptor;
import com.yeoljeong.tripmate.auth.passport.PassportValidator;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {

    private final PassportValidator passportValidator;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserContextInterceptor(passportValidator))
            .excludePathPatterns("/auth/login", "/auth/refresh", "/users/signup", "/internal/**");

    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new LoginUserArgumentResolver());
    }
}
