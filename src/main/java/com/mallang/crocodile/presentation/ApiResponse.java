package com.mallang.crocodile.presentation;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ApiResponse<T> {
	@Builder.Default
	private ApiResponseStatus status = ApiResponseStatus.SUCCESS;
	private final T data;

	public String getMessage() {
		return status.getMessage();
	}
}
