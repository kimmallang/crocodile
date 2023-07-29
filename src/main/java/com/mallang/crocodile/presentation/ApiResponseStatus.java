package com.mallang.crocodile.presentation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApiResponseStatus {
	SUCCESS("SUCCESS", "요청이 성공적으로 처리되었습니다."),
	SERVER_ERROR("SERVER_ERROR", "서버 오류가 발생했습니다."),
	BAD_REQUEST("BAD_REQUEST", "요청이 올바르지 않습니다."),
	FORBIDDEN("FORBIDDEN", "요청 권한이 없습니다.");

	private final String status;
	private final String message;
}
