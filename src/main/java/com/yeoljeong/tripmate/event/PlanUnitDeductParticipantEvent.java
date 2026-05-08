package com.yeoljeong.tripmate.event;

import java.util.UUID;

public record PlanUnitDeductParticipantEvent(
    UUID eventId,
    UUID orderId
) {
}
