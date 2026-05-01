package com.yeoljeong.tripmate.event.notification.payload;

import com.yeoljeong.tripmate.event.notification.constants.NotificationType;
import lombok.Builder;
import lombok.Getter;

public class MatchingPayload {

  @Builder
  @Getter
  public static class CREATED implements NotificationPayload {

    String receiverName;
    String matchingTitle;

    @Override
    public NotificationType getType() {
      return NotificationType.MATCHING_CREATED;
    }
  }

  @Builder
  public static class FAILED implements NotificationPayload {

    String matchingUserName;
    String matchingTitle;

    @Override
    public NotificationType getType() {
      return NotificationType.MATCHING_FAILED;
    }
  }

  @Builder
  public static class SUCCEED implements NotificationPayload {

    String receiverName;

    @Override
    public NotificationType getType() {
      return NotificationType.MATCHING_MATCHED;
    }
  }
}
