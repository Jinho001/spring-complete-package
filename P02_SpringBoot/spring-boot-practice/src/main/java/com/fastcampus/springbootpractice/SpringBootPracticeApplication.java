package com.fastcampus.springbootpractice;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;

@SpringBootApplication(
		exclude = WebMvcAutoConfiguration.class
)
public class SpringBootPracticeApplication {

	@Value("${my.height}")
	private int height;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPracticeApplication.class, args);

		SpringBootPracticeApplication app = new SpringBootPracticeApplication();


	}

	@PostConstruct
	public void init() {
		System.out.println("[@Value] "+height);
	}
}
