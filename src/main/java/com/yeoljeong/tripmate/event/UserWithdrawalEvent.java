package com.yeoljeong.tripmate.event;

import java.util.UUID;

public record UserWithdrawalEvent(
	UUID userId,
	String role
) {

}
