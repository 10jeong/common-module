package com.yeoljeong.tripmate.event.notification;

import com.yeoljeong.tripmate.event.notification.constants.NotificationType;
import com.yeoljeong.tripmate.event.notification.payload.NotificationPayload;
import java.util.UUID;

public record NotificationSendEvent<P extends NotificationPayload>(
    String eventHash,
    UUID refId,
    String redirectUrl,
    NotificationType notificationType,
    NotificationPayload payload
) {

  private static <P extends NotificationPayload> NotificationSendEvent<P> of(
      String eventHash,
      UUID refId,
      String redirectUrl,
      P payload
  ) {
    return new NotificationSendEvent<>(
        eventHash, refId, redirectUrl, payload.getType(), payload
    );
  }
}
