package com.yeoljeong.tripmate.domain;

import com.yeoljeong.tripmate.domain.constants.OutboxStatus;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class Outbox {

	private final static int MAX_RETRY_COUNT = 3;

	@Column(nullable = false, length = 100)
	private String topic;

	@Column(nullable = false, columnDefinition = "TEXT")
	private String payload;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private OutboxStatus status;

	@Column(nullable = false)
	private int retryCount;

	@Column(nullable = false)
	private LocalDateTime createdAt;

	private LocalDateTime publishedAt;

	protected static void init(Outbox outbox, String topic, String payload) {
		outbox.topic = topic;
		outbox.payload = payload;
		outbox.status = OutboxStatus.PENDING;
		outbox.retryCount = 0;
		outbox.createdAt = LocalDateTime.now();
	}

	public void published() {
		this.status = OutboxStatus.PUBLISHED;
		this.publishedAt = LocalDateTime.now();
	}

	public void fail() {
		this.retryCount++;
		if (this.retryCount >= MAX_RETRY_COUNT) {
			this.status = OutboxStatus.FAILED;
		}
	}

	public boolean isExceededRetryCount() {
		return this.retryCount >= MAX_RETRY_COUNT;
	}
}
