package com.yeoljeong.tripmate.config;

import com.yeoljeong.tripmate.auth.LoginUserArgumentResolver;
import com.yeoljeong.tripmate.auth.UserContextInterceptor;
import java.util.List;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserContextInterceptor())
            .excludePathPatterns("/auth/login", "/auth/refresh", "/users/signup", "/internal/**");

    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new LoginUserArgumentResolver());
    }
}
