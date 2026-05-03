package com.yeoljeong.tripmate.event;

import java.util.List;
import java.util.UUID;

public record MatchingCandidatesFoundEvent (
	String eventHash,
	UUID hostUserId,
	List<UUID> userIds
) {
}