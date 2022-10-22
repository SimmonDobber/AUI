package com.example.aui;

import com.example.aui.components.InitializerComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuiApplication.class, args);
        new InitializerComponent().initialize();
    }

}
