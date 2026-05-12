package com.yeoljeong.tripmate.event;

import java.util.UUID;

public record PlanUnitDeductParticipantByOrderEvent(
    UUID eventId,
    UUID productId,
    UUID scheduleId,
    int quantity
) {

}
