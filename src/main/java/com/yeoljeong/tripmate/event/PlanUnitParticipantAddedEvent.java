package com.yeoljeong.tripmate.event;

import java.util.UUID;

public record PlanUnitParticipantAddedEvent(
    UUID eventId,
    UUID productId,
    UUID scheduleId,
    UUID planUnitId,
    UUID userId,
    int quantity
) {

}
