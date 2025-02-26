package com.example.ogh_test_backend.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 스프링 버전에 따라서 Swagger의 버전도 맞춰서 변경

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(apiInfo());
    }

    private Info apiInfo() {
        return new Info()
                .title("스프링 테스트 프로젝트 기능 테스트")
                .description("스프링 테스트 프로젝트 기능을 테스트 하기 위한 웹 페이지")
                .version("1.0.0");
    }
}

