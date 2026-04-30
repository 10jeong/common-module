package com.yeoljeong.tripmate.event.notification.payload;

import com.yeoljeong.tripmate.event.notification.constants.NotificationType;

public interface NotificationPayload {

  NotificationType getType();
}
