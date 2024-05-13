package com.backend.tinkoff_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class TinkoffBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(TinkoffBackendApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins(
                                "http://localhost:8000",
                                "http://localhost:3000",
                                "https://skipper-frontend:3000",
                                "https://skipper-frontend:8000"
                        );

            }
        };
    }

}
