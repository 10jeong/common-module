package com.yeoljeong.tripmate.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseAuditEntity extends BaseTimeEntity {

	@CreatedBy
	@Column(name = "created_by", updatable = false)
	protected UUID createdBy;

	@LastModifiedBy
	@Column(name = "updated_by")
	protected UUID updatedBy;

	@Column(name = "is_deleted")
	protected boolean isDeleted;

	public void softDelete() {
		this.isDeleted = true;
	}
}
