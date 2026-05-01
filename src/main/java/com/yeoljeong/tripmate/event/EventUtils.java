package com.yeoljeong.tripmate.event;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.HexFormat;

public class EventUtils {

  public static String getEventHash(String domainName, String refId, LocalDateTime updateAt)
      throws NoSuchAlgorithmException {
    String rawKey = String.format("%s:%s:%s", domainName, refId, updateAt.toString());
    MessageDigest digest = MessageDigest.getInstance("SHA-256");
    byte[] hash = digest.digest(rawKey.getBytes(StandardCharsets.UTF_8));
    return HexFormat.of().formatHex(hash);
  }
}
