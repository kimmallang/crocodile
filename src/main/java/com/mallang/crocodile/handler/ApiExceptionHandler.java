package com.mallang.crocodile.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mallang.crocodile.presentation.ApiResponse;
import com.mallang.crocodile.presentation.ApiResponseStatus;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {
	@ExceptionHandler(Exception.class)
	public ApiResponse<Object> handleServerError(Exception e) {
		log.error("[SERVER_ERROR] {}", e.getMessage(), e);

		return ApiResponse.builder()
			.status(ApiResponseStatus.SERVER_ERROR)
			.build();
	}
}
