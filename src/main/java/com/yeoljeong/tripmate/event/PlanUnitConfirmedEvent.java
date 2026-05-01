package com.yeoljeong.tripmate.event;

import java.util.List;
import java.util.UUID;

public record PlanUnitConfirmedEvent(
    String eventHash,
    UUID planUnitId,
    String planTitle,
    List<UUID> receivers
) {

}