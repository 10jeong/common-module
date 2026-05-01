package com.yeoljeong.tripmate.event.notification.payload;

import com.yeoljeong.tripmate.event.notification.constants.NotificationType;
import lombok.Builder;

public class PlanPayload {

  @Builder
  public static class CONFIRMED implements NotificationPayload {

    String planTitle;

    @Override
    public NotificationType getType() {
      return NotificationType.PAYMENT_SUCCEED;
    }
  }
}
