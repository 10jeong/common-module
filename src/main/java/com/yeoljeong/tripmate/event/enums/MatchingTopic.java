package com.yeoljeong.tripmate.event.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MatchingTopic {

    /*
     * 토픽에 대한 컨벤션은 "domain.resource.active"로 합니다. (~가 ~를 한다.)
     */

    MATCHING_CANDIDATES_FOUND_TOPIC("matching.candidates.found"),
    MATCHING_CREATED_TOPIC("matching.created"),
    MATCHING_APPLIED_TOPIC("matching.applied"),
    MATCHING_DISAPPLIED_TOPIC("matching.disapplied"),
    ;
    private final String name;

}
