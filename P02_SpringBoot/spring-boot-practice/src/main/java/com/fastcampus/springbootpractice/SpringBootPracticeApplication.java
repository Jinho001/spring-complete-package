package com.fastcampus.springbootpractice;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
@RequiredArgsConstructor
public class SpringBootPracticeApplication {

    private final MyProperties myProperties;


    public static void main(String[] args) {
        SpringApplication.run(SpringBootPracticeApplication.class, args);
    }
}
