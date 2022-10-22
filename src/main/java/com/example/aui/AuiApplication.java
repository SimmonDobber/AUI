package com.example.aui;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;

@SpringBootApplication
public class AuiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuiApplication.class, args);
    }

}
