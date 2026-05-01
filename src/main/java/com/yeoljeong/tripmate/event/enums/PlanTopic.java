package com.yeoljeong.tripmate.event.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum PlanTopic {

    /*
     * 토픽에 대한 컨벤션은 "domain.resource.active"로 합니다. (~가 ~를 한다.)
     */

    PLAN_PARTICIPANT_ADDED_TOPIC("plan.participant.added"),
    PLAN_UNIT_CONFIRMED_TOPIC("plan.unit.confirmed"),
    ;
    private final String name;

}
