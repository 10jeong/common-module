package com.yeoljeong.tripmate.event.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum UserTopic {

    /*
     * 토픽에 대한 컨벤션은 "domain.resource.active"로 합니다. (~가 ~를 한다.)
     */

    USER_CREATED_TOPIC("user.created"),
    ;
    private final String name;

}
