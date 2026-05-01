package com.yeoljeong.tripmate.event.notification.payload;

import com.yeoljeong.tripmate.event.notification.constants.NotificationType;
import lombok.Builder;
import lombok.Getter;

public class PlanPayload {

  @Builder
  @Getter
  public static class CONFIRMED implements NotificationPayload {

    private String planTitle;

    @Override
    public NotificationType getType() {
      return NotificationType.PAYMENT_SUCCEED;
    }
  }
}
