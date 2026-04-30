package com.yeoljeong.tripmate.event;

import java.util.UUID;

public record UserCreatedEvent (
	UUID userId,
	String gender
) {

}
