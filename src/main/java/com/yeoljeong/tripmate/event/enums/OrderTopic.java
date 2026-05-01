package com.yeoljeong.tripmate.event.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum OrderTopic {

    /*
     * 토픽에 대한 컨벤션은 "domain.resource.active"로 합니다. (~가 ~를 한다.)
     */

    ORDER_CREATED_TOPIC("order.created"),
    ;
    private final String name;

}
