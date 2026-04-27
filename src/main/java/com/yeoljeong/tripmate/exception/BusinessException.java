package com.yeoljeong.tripmate.exception;

import com.yeoljeong.tripmate.exception.constants.ErrorCode;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException{

	private final ErrorCode errorCode;

	public BusinessException(ErrorCode errorCode) {
		super(errorCode.getMessage());
		this.errorCode = errorCode;
	}

}
