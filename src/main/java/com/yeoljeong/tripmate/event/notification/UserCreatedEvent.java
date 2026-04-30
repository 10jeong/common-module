package com.yeoljeong.tripmate.event.notification;

import java.util.UUID;

public record UserCreatedEvent (
	UUID userId,
	String gender
) {

}
