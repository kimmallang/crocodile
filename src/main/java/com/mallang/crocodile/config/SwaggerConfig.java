package com.mallang.crocodile.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	/**
	 * Docket 은 스웨거에서 제공하는 스웨거 설정 빌더입니다.
	 * Docket 을 이용해서 스웨거에 대한 설정을 관리할 수 있습니다.
	 */
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.OAS_30)
			.useDefaultResponseMessages(false)
			.select()
			.apis(RequestHandlerSelectors.basePackage("com.mallang.crocodile"))
			.paths(PathSelectors.any())
			.build()
			.apiInfo(new ApiInfoBuilder()
				.title("Todook API")
				.description("Todook API 입니다.")
				.build());
	}
}
