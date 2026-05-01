package com.yeoljeong.tripmate.event;

import java.util.UUID;

public record OrderCreatedEvent(
    UUID eventId,       // 중복 처리 방지용(멱등성 처리는 추후에)
    UUID planUnitId,    // 어떤 단위일정인지 (일정)
    UUID productId,     // 어떤 상품인지 (상품)
    UUID scheduleId,    // 어떤 일자인지 (상품)
    int quantity        // 몇 명 추가됐는지 (상품)
) {

}
