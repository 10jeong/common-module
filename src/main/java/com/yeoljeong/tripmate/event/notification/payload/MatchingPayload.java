package com.yeoljeong.tripmate.event.notification.payload;

import com.yeoljeong.tripmate.event.notification.constants.NotificationType;
import lombok.Builder;
import lombok.Getter;

public class MatchingPayload {

  @Builder
  @Getter
  public static class CREATED implements NotificationPayload {

    private String receiverName;
    private String matchingTitle;

    @Override
    public NotificationType getType() {
      return NotificationType.MATCHING_CREATED;
    }
  }

  @Builder
  @Getter
  public static class FAILED implements NotificationPayload {

    private String matchingUserName;
    private String matchingTitle;

    @Override
    public NotificationType getType() {
      return NotificationType.MATCHING_FAILED;
    }
  }

  @Builder
  @Getter
  public static class SUCCEED implements NotificationPayload {

    private String receiverName;

    @Override
    public NotificationType getType() {
      return NotificationType.MATCHING_MATCHED;
    }
  }
}
