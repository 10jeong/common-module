package com.yeoljeong.tripmate.event.enums;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class OrderTopic {

    /*
     * 토픽에 대한 컨벤션은 "domain.resource.active"로 합니다. (~가 ~를 한다.)
     */

    public static final String ORDER_CREATED_TOPIC = "order.created";

}