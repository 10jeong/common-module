package com.yeoljeong.tripmate.event;

import java.math.BigDecimal;
import java.util.UUID;

public record PaymentRefundedEvent(
    String eventHash,
    UUID userId,
    UUID productId,
    String productName,
    UUID scheduleId,
    int quantity,
    BigDecimal paymentPrice
) {

}
