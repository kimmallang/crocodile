package com.mallang.crocodile.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mallang.crocodile.exception.NotAllowedRefererException;
import com.mallang.crocodile.presentation.ApiResponse;
import com.mallang.crocodile.presentation.ApiResponseStatus;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleServerError(Exception e) {
		log.error("[SERVER_ERROR] {}", e.getMessage(), e);

		final ApiResponse<Object> apiResponse = ApiResponse.builder()
			.status(ApiResponseStatus.INTERNAL_SERVER_ERROR)
			.build();

		return new ResponseEntity<>(apiResponse, apiResponse.getHttpStatus());
	}

	@ExceptionHandler(NotAllowedRefererException.class)
	public ResponseEntity<Object> handleNotAllowedReferer(Exception e) {
		log.error("[FORBIDDEN] {}", e.getMessage(), e);

		final ApiResponse<Object> apiResponse = ApiResponse.builder()
			.status(ApiResponseStatus.FORBIDDEN)
			.build();

		return new ResponseEntity<>(apiResponse, apiResponse.getHttpStatus());
	}
}
