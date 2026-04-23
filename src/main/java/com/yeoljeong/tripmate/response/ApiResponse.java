package com.yeoljeong.tripmate.response;

import com.yeoljeong.tripmate.common.BaseCode;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class ApiResponse<T> {

	private final int code;
	private final boolean isSuccess;
	private final String message;
	private final T data;
	private final LocalDateTime timestamp;

	private ApiResponse(BaseCode code, boolean isSuccess, T data) {
		this.code = code.getCode();
		this.isSuccess = isSuccess;
		this.message = code.getMessage();
		this.data = data;
		this.timestamp = LocalDateTime.now();
	}

	private ApiResponse(BaseCode code, boolean isSuccess, String message, T data) {
		this.code = code.getCode();
		this.isSuccess = isSuccess;
		this.message = message;
		this.data = data;
		this.timestamp = LocalDateTime.now();
	}

	public static <T> ApiResponse<T> success(BaseCode successCode, String message, T data) {
		return new ApiResponse<>(successCode, true, message, data);
	}

	public static <T> ApiResponse<T> success(BaseCode successCode, T data) {
		return new ApiResponse<>(successCode, true, data);
	}

	public static <T> ApiResponse<T> error(BaseCode errorCode) {
		return new ApiResponse<>(errorCode, false, null);
	}

	public static <T> ApiResponse<T> error(BaseCode errorCode, String message) {
		return new ApiResponse<>(errorCode, false, message, null);
	}

	public static <T> ApiResponse<T> error(BaseCode errorCode, T data) {
		return new ApiResponse<>(errorCode, false, data);
	}
}
