package com.yeoljeong.tripmate.exception;

import com.yeoljeong.tripmate.exception.constants.CommonErrorCode;
import com.yeoljeong.tripmate.exception.constants.FieldErrorDetail;
import com.yeoljeong.tripmate.response.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
public class GlobalExceptionHandler {

	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<ApiResponse<Void>> handleBusinessException(BusinessException e) {
		return ResponseEntity
			.status(e.getErrorCode().getStatus())
			.body(ApiResponse.error(e.getErrorCode()));
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiResponse<List<FieldErrorDetail>>> handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
		List<FieldErrorDetail> fieldErrors = e.getBindingResult().getFieldErrors()
			.stream()
			.map(fe -> new FieldErrorDetail(fe.getField(), fe.getDefaultMessage()))
			.toList();

		return ResponseEntity
			.status(HttpStatus.BAD_REQUEST)
			.body(ApiResponse.error(CommonErrorCode.INVALID_INPUT, fieldErrors));
	}

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<ApiResponse<Void>> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException e) {
		return ResponseEntity
			.status(HttpStatus.METHOD_NOT_ALLOWED)
			.body(ApiResponse.error(CommonErrorCode.METHOD_NOT_ALLOWED));
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiResponse<Void>> handleException(Exception e, HttpServletRequest request) {
		log.error("[Unhandled Exception] {} {}", request.getMethod(), request.getRequestURI(), e);
		return ResponseEntity
			.status(HttpStatus.INTERNAL_SERVER_ERROR)
			.body(ApiResponse.error(CommonErrorCode.INTERNAL_SERVER_ERROR));
	}
}