package com.yeoljeong.tripmate.event;

import java.util.UUID;

public record PlanUnitDeductParticipantByProductEvent(
    UUID eventId,
    UUID orderId
) {
}
