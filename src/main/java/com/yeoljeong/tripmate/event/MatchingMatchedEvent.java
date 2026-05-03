package com.yeoljeong.tripmate.event;

import java.util.UUID;

public record MatchingMatchedEvent(
    String eventHash,
    UUID matchingId,
    UUID hostUserId,
    UUID mateUserId,
    String title
) {}