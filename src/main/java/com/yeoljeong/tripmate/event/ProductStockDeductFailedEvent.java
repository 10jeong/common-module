package com.yeoljeong.tripmate.event;

import java.util.UUID;

public record ProductStockDeductFailedEvent(
    UUID eventId,
    UUID orderId,
    UUID planUnitId,
    UUID userId,
    int quantity
) {
}
