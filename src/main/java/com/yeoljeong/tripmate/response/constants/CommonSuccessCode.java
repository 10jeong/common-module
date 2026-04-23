package com.yeoljeong.tripmate.response.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum CommonSuccessCode implements SuccessCode {
	OK(HttpStatus.OK, "성공하였습니다."),
	CREATE(HttpStatus.CREATED, "생성되었습니다."),
	DELETE(HttpStatus.NO_CONTENT, "삭제되었습니다."),
	;

	private final HttpStatus status;
	private final String message;

	@Override
	public int getCode() {
		return this.status.value();
	}
}

