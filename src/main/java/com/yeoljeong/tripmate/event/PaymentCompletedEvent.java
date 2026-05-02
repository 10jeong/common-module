package com.yeoljeong.tripmate.event;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record PaymentCompletedEvent(
        String eventHash,
        UUID userId,
        UUID orderId,
        UUID paymentId,
        String productName,
        BigDecimal paymentPrice,
        Instant paymentDateTime,
        String paymentMethod
) { }
