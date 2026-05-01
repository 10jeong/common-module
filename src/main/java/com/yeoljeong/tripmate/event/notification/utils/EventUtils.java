package com.yeoljeong.tripmate.event.notification.utils;

import com.yeoljeong.tripmate.event.notification.constants.NotificationType;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.HexFormat;

public class EventUtils {

  public static String getEventHash(NotificationType type, String refId, LocalDateTime updateAt)
      throws NoSuchAlgorithmException {
    String rawKey = String.format("%s:%s:%s", type.toString(), refId, updateAt.toString());
    MessageDigest digest = MessageDigest.getInstance("SHA-256");
    byte[] hash = digest.digest(rawKey.getBytes(StandardCharsets.UTF_8));
    return HexFormat.of().formatHex(hash);
  }
}
