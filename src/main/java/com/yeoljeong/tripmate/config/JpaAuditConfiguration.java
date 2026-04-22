package com.yeoljeong.tripmate.config;

import java.util.Optional;
import java.util.UUID;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@Configuration
public class JpaAuditConfiguration {

	@Bean
	public AuditorAware<UUID> auditorAware() {
		return () -> Optional.of(UUID.fromString("00000000-0000-0000-0000-000000000000"));
	}
}
