package com.example.petshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class PetshopApplication implements WebMvcConfigurer{

    public static void main(String[] args) {
        SpringApplication.run(PetshopApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer configure() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry reg) {
                reg.addMapping("/**").allowedOrigins("http://localhost:3000").allowedMethods("POST", "PUT", "GET",
                        "DELETE");
            }
        };
    }
}
