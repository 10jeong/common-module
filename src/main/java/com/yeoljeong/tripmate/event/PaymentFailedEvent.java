package com.yeoljeong.tripmate.event;

import java.math.BigDecimal;
import java.util.UUID;

public record PaymentFailedEvent(
        UUID eventId,
        UUID userId,
        UUID orderId,
        UUID paymentId,
        String productName,
        BigDecimal paymentPrice,
        String paymentErrorMessage
) { }
