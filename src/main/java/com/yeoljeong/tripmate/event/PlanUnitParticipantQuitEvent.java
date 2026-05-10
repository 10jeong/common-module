package com.yeoljeong.tripmate.event;

import java.util.UUID;

public record PlanUnitParticipantQuitEvent(
    UUID eventId,
    UUID userId,
    UUID planUnitId,
    String reason
) {
}
