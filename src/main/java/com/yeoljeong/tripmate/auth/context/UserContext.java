package com.yeoljeong.tripmate.auth.context;

import java.util.UUID;

public record UserContext(UUID userId, String role) {

}
