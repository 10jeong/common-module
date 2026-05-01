package com.yeoljeong.tripmate.event.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PaymentTopic {

    /*
     * 토픽에 대한 컨벤션은 "domain.resource.active"로 합니다. (~가 ~를 한다.)
     */

    PAYMENT_COMPLETED_TOPIC("payment.completed"),
    PAYMENT_FAILED_TOPIC("payment.failed"),
    ;
    private final String name;

}
