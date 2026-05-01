package com.yeoljeong.tripmate.event.notification.payload;

import com.yeoljeong.tripmate.event.notification.constants.NotificationType;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

public class PaymentPayload {

  @Builder
  @Getter
  public static class SUCCEED implements NotificationPayload {

    private String productName;
    private Long paymentPrice;
    private LocalDateTime paymentDateTime;
    private String paymentMethod;

    @Override
    public NotificationType getType() {
      return NotificationType.PAYMENT_SUCCEED;
    }
  }

  @Builder
  @Getter
  public static class FAILED implements NotificationPayload {

    private String productName;
    private Long paymentPrice;
    private String paymentMethod;
    private String paymentErrorMessage;

    @Override
    public NotificationType getType() {
      return NotificationType.PAYMENT_SUCCEED;
    }
  }
}
