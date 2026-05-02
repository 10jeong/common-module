package com.yeoljeong.tripmate.config;

import com.yeoljeong.tripmate.auth.context.UserContext;
import com.yeoljeong.tripmate.auth.context.UserContextHolder;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

@Component
public class UserAuditorAware implements AuditorAware<UUID> {

    @Override
    public Optional<UUID> getCurrentAuditor() {
        UserContext context = UserContextHolder.getContext();
        if (context == null) {
            return Optional.empty();
        }
        return Optional.of(context.userId());
    }
}
