package com.mallang.crocodile.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mallang.crocodile.interceptor.RefererCheckInterceptor;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {
	private final CrocodileConfig crocodileConfig;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new RefererCheckInterceptor(crocodileConfig))
			// all
			.addPathPatterns("/**")
			// swagger
			.excludePathPatterns("/v3/api-docs")
			.excludePathPatterns("/swagger-resources/**")
			.excludePathPatterns("/swagger-ui/**")
			.excludePathPatterns("/webjars/**");
	}
}
