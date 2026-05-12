package com.yeoljeong.tripmate.event;

import java.util.UUID;

public record OrderSchedulerCancelledEvent(
    UUID eventId,
    UUID userId,
    UUID planUnitId,
    UUID productId,
    UUID scheduleId,
    int quantity
) {

}
