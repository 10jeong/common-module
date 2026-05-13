package com.yeoljeong.tripmate.event.enums;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UserTopic {

    /*
     * 토픽에 대한 컨벤션은 "domain.resource.active"로 합니다. (~가 ~를 한다.)
     */

    public static final String USER_CREATED_TOPIC = "user.created";
    public static final String USER_WITHDRAWAL_COMPLETED_TOPIC = "user.withdrawal.completed";
    public static final String USER_LOGOUT_TOPIC = "user.logout";

}