package com.yeoljeong.tripmate.event.notification.payload;

import com.yeoljeong.tripmate.event.notification.constants.NotificationType;
import lombok.Builder;

public class MatchingPayload {

  @Builder
  public record CREATED(
      String receiverName,
      String matchingTitle
  ) implements NotificationPayload {

    @Override
    public NotificationType getType() {
      return NotificationType.MATCHING_CREATED;
    }
  }

  @Builder
  public record FAILED(
      String matchingUserName,
      String matchingTitle
  ) implements NotificationPayload {

    @Override
    public NotificationType getType() {
      return NotificationType.MATCHING_FAILED;
    }
  }

  @Builder
  public record SUCCEED(
      String receiverName
  ) implements NotificationPayload {

    @Override
    public NotificationType getType() {
      return NotificationType.MATCHING_MATCHED;
    }
  }
}
