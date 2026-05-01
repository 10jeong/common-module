package com.yeoljeong.tripmate.auth.context;

public class UserContextHolder {

    /*
     * UserContext를 ThreadLocal에 보관하는 로직을 수행합니다.
     * */

    private static final ThreadLocal<UserContext> holder = new ThreadLocal<>();

    public static void setContext(UserContext context) {
        holder.set(context);
    }

    public static UserContext getContext() {
        return holder.get();
    }

    public static void clear() {
        holder.remove();
    }
}
