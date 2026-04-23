package com.yeoljeong.tripmate.response;

import com.yeoljeong.tripmate.common.BaseCode;
import com.yeoljeong.tripmate.exception.constants.ErrorCode;
import com.yeoljeong.tripmate.response.constants.SuccessCode;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class ApiResponse<T> {

	private final int code;
	private final boolean isSuccess;
	private final String message;
	private final T data;
	private final LocalDateTime timestamp;

	private ApiResponse(boolean isSuccess, BaseCode code, T data) {
		this.code = code.getCode();
		this.isSuccess = isSuccess;
		this.message = code.getMessage();
		this.data = data;
		this.timestamp = LocalDateTime.now();
	}

	private ApiResponse(boolean isSuccess, BaseCode code, String message, T data) {
		this.code = code.getCode();
		this.isSuccess = isSuccess;
		this.message = message;
		this.data = data;
		this.timestamp = LocalDateTime.now();
	}

	public static <T> ApiResponse<T> success(SuccessCode successCode, String message, T data) {
		return new ApiResponse<>(true, successCode, message, data);
	}

	public static <T> ApiResponse<T> success(SuccessCode successCode, T data) {
		return new ApiResponse<>(true, successCode, data);
	}

	public static <T> ApiResponse<T> error(ErrorCode errorCode) {
		return new ApiResponse<>(false, errorCode, null);
	}

	public static <T> ApiResponse<T> error(BaseCode errorCode, String message) {
		return new ApiResponse<>(false, errorCode, message, null);
	}

	public static <T> ApiResponse<T> error(BaseCode errorCode, T data) {
		return new ApiResponse<>(false, errorCode, data);
	}
}
