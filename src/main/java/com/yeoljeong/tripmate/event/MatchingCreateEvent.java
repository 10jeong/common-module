package com.yeoljeong.tripmate.event;

import java.util.UUID;

public record MatchingCreateEvent (
    UUID matchingId,
    UUID hostUserId,
    String title,
    boolean allowSmoking,
    String preferenceMbtiIE,
    String preferenceMbtiSN,
    String preferenceMbtiTF,
    String preferenceMbtiPJ,
    String preferenceGender
) {

}