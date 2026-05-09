package com.yeoljeong.tripmate.event;

import java.util.UUID;

public record OrderCancelledEvent(
    UUID eventId,
    UUID orderId,
    UUID userId,
    UUID planUnitId,
    UUID productId,
    String productName,
    UUID scheduleId,
    int quantity
) {

}
