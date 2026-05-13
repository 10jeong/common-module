package com.yeoljeong.tripmate.event.enums;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MatchingTopic {

    /*
     * 토픽에 대한 컨벤션은 "domain.resource.active"로 합니다. (~가 ~를 한다.)
     */

    public static final String MATCHING_CANDIDATES_FOUND_TOPIC = "matching.candidates.found";
    public static final String MATCHING_CREATED_TOPIC = "matching.created";
    public static final String MATCHING_APPLIED_TOPIC = "matching.applied";
    public static final String MATCHING_DISAPPLIED_TOPIC = "matching.disapplied";
    public static final String MATCHING_MATCHED_TOPIC = "matching.matched";
    public static final String MATCHING_MATE_SUBSCRIBED_TOPIC = "matching.mate.subscribed";
    public static final String MATCHING_MATE_UNSUBSCRIBED_TOPIC = "matching.mate.unsubscribed";


}