package com.yeoljeong.tripmate.auth.context;

import com.yeoljeong.tripmate.auth.annotation.LoginUser;
import org.springframework.core.MethodParameter;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class LoginUserArgumentResolver implements HandlerMethodArgumentResolver {

    /*
     * @LoginUser annotation에 대한 값을 검증하고 값을 추가합니다.
     * */

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(LoginUser.class)
            && parameter.getParameterType().equals(UserContext.class);
    }

    @Nullable
    @Override
    public Object resolveArgument(MethodParameter parameter,
        @Nullable ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
        @Nullable WebDataBinderFactory binderFactory) throws Exception {
        return UserContextHolder.getContext();
    }
}
