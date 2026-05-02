package com.yeoljeong.tripmate.auth.aop;

import com.yeoljeong.tripmate.auth.annotation.RequireRole;
import com.yeoljeong.tripmate.auth.context.UserContext;
import com.yeoljeong.tripmate.auth.context.UserContextHolder;
import com.yeoljeong.tripmate.exception.BusinessException;
import com.yeoljeong.tripmate.exception.constants.CommonErrorCode;
import java.util.Arrays;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RequireRoleAspect {

    @Before("@annotation(requireRole)")
    public void checkRole(RequireRole requireRole) {
        UserContext context = UserContextHolder.getContext();

        if (context == null) {
            throw new BusinessException(CommonErrorCode.UNAUTHORIZED);
        }

        String[] allowedRoles = requireRole.value();
        String userRole = context.role();

        if (!Arrays.asList(allowedRoles).contains(userRole)) {
            throw new BusinessException(CommonErrorCode.FORBIDDEN);
        }
    }
}
