package com.yeoljeong.tripmate.auth.context;

import com.yeoljeong.tripmate.auth.passport.PassportValidator;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.web.servlet.HandlerInterceptor;

@RequiredArgsConstructor
public class UserContextInterceptor implements HandlerInterceptor {

    /*
     * 헤더를 읽어서 TreadLocal에 저장하며, 요청이 끝나면 clear()합니다.
     * */

    private static final String HEADER_PASSPORT = "X-Passport";
    private final PassportValidator passportValidator;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
        Object handler) {
        String passport = request.getHeader(HEADER_PASSPORT);

        if (passport == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }

        try {
            Claims claims = passportValidator.validate(passport);
            UUID userId = UUID.fromString(claims.getSubject());
            String role = claims.get("role", String.class);
            UserContextHolder.setContext(new UserContext(userId, role));
        } catch (JwtException | IllegalArgumentException e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }

        return true;

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
        Object handler, Exception ex) {
        UserContextHolder.clear();
    }
}
