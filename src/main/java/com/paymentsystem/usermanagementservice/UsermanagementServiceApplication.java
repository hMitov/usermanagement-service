package com.paymentsystem.usermanagementservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class UsermanagementServiceApplication {

    @Bean
    public WebClient getWebClientBuilder() {
        return WebClient.builder()
                .baseUrl("http://localhost:8081/api")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(UsermanagementServiceApplication.class, args);
    }

}
