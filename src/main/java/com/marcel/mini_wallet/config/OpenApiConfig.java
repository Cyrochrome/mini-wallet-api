package com.marcel.mini_wallet.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Mini Wallet API")
                        .version("1.0.0")
                        .description("Dokumentasi API untuk Project Mini Wallet")
                        .contact(new Contact()
                                .name("Marshalinas Yustiawan (Marcel)")
                                .email("marshalinas82@gmail.com")));
    }
}