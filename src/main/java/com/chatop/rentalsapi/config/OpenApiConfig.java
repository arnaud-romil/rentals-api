package com.chatop.rentalsapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class OpenApiConfig {

        @Bean
        public OpenAPI customOpenAPI() {
                return new OpenAPI()
                                .info(new Info()
                                                .title("Rentals API Documentation")
                                                .version("1.0")
                                                .description("Documentation of the rentals API endpoints"))
                                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
                                .components(new Components().addSecuritySchemes("bearerAuth",
                                                new SecurityScheme().type(SecurityScheme.Type.HTTP)
                                                                .scheme("bearer")
                                                                .bearerFormat("JWT")));
        }
}