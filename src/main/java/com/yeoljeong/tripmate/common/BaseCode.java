package com.yeoljeong.tripmate.common;

import org.springframework.http.HttpStatus;

public interface BaseCode {
	int getCode();
	HttpStatus getStatus();
	String getMessage();
}
