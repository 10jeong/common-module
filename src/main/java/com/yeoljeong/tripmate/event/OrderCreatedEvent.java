package com.yeoljeong.tripmate.event;

import java.util.UUID;

public record OrderCreatedEvent(
    UUID eventId,
    UUID userId,
    UUID orderId,
    UUID planUnitId,
    UUID productId,
    UUID scheduleId,
    int quantity
) {

}
