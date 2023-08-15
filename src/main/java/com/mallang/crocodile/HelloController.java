package com.mallang.crocodile;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mallang.crocodile.infrastructure.HelloRepository;
import com.mallang.crocodile.presentation.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class HelloController {
	private final HelloRepository helloRepository;

	@GetMapping("/hello")
	public ApiResponse<String> hello() {
		Integer count = helloRepository.countAll();
		return ApiResponse.<String>builder()
			.data(String.valueOf(count))
			.build();
	}

	@GetMapping("/hello/error")
	public ApiResponse<String> helloError() throws Exception {
		throw new Exception("임시로 만든 에러");
	}
}
