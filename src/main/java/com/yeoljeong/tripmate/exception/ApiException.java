package com.yeoljeong.tripmate.exception;

import com.yeoljeong.tripmate.common.BaseCode;
import lombok.Getter;

@Getter
public class ApiException extends RuntimeException{

	private final BaseCode errorCode;

	public ApiException(BaseCode errorCode) {
		super(errorCode.getMessage());
		this.errorCode = errorCode;
	}

}
