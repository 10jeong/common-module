package com.yeoljeong.tripmate.auth.context;

import com.yeoljeong.tripmate.auth.passport.PassportValidator;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.SignatureException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;


@Slf4j
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
            log.warn("[Passport] X-Passport 헤더 없음 - uri: {}", request.getRequestURI());
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }

        try {
            Claims claims = passportValidator.validate(passport);

            String subject = claims.getSubject();
            String role = claims.get("role", String.class);

            if (subject == null || subject.isBlank() || role == null || role.isBlank()) {
                log.warn("[Passport] 필수 claim 누락 - uri: {}", request.getRequestURI());
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return false;
            }

            UUID userId = UUID.fromString(subject);
            UserContextHolder.setContext(new UserContext(userId, role));
        } catch (ExpiredJwtException e) {
            log.warn("[Passport] 만료된 Passport - uri: {}", request.getRequestURI());
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        } catch (SignatureException e) {
            log.warn("[Passport] 서명 검증 실패 - uri: {}", request.getRequestURI());
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        } catch (MalformedJwtException | UnsupportedJwtException e) {
            log.warn("[Passport] 잘못된 Passport 형식 - uri: {}", request.getRequestURI());
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        } catch (IllegalArgumentException e) {
            log.warn("[Passport] userId UUID 파싱 실패 - uri: {}", request.getRequestURI());
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
