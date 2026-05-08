package com.yeoljeong.tripmate.event;

import java.util.UUID;

public record PlanUnitAddParticipantFailedEvent(
    UUID eventId,
    UUID orderId
) {
}
