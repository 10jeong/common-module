package com.yeoljeong.tripmate.event.notification.payload;

import com.yeoljeong.tripmate.event.notification.constants.NotificationType;
import lombok.Builder;

public class PlanPayload {

  @Builder
  public record CONFIRMED(
      String planTitle
  ) implements NotificationPayload {

    @Override
    public NotificationType getType() {
      return NotificationType.PAYMENT_SUCCEED;
    }
  }
}
