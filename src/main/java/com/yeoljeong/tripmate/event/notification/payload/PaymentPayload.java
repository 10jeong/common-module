package com.yeoljeong.tripmate.event.notification.payload;

import com.yeoljeong.tripmate.event.notification.constants.NotificationType;
import java.time.LocalDateTime;
import lombok.Builder;

public class PaymentPayload {

  @Builder
  public record SUCCEED(
      String productName,
      Long paymentPrice,
      LocalDateTime paymentDateTime,
      String paymentMethod
  ) implements NotificationPayload {

    @Override
    public NotificationType getType() {
      return NotificationType.PAYMENT_SUCCEED;
    }
  }

  @Builder
  public record FAILED(
      String productName,
      Long paymentPrice,
      String paymentMethod,
      String paymentErrorMessage
  ) implements NotificationPayload {

    @Override
    public NotificationType getType() {
      return NotificationType.PAYMENT_SUCCEED;
    }
  }
}
