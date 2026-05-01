package com.yeoljeong.tripmate.event.notification;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.yeoljeong.tripmate.event.notification.constants.NotificationType;
import com.yeoljeong.tripmate.event.notification.payload.NotificationPayload;
import java.io.IOException;
import java.util.UUID;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class NotificationSendEvent<P extends NotificationPayload> {

  private String eventHash;
  private UUID refId;
  private String redirectUrl;
  private NotificationType notificationType;
  private JsonNode payload;

  public NotificationSendEvent
      (String eventHash, UUID refId, String redirectUrl, NotificationType type, JsonNode payload) {
    this.eventHash = eventHash;
    this.redirectUrl = redirectUrl;
    this.notificationType = type;
    this.payload = payload;
  }

  public static <P extends NotificationPayload> NotificationSendEvent<P> of(
      String eventHash,
      UUID refId,
      String redirectUrl,
      P payload
  ) throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.registerModule(new JavaTimeModule());
    objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    return new NotificationSendEvent<P>(
        eventHash,
        refId,
        redirectUrl,
        payload.getType(),
        objectMapper.valueToTree(payload)
    );
  }
}