package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@ComponentScan({"test.*"})
public class SpringGradleThymeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringGradleThymeApplication.class, args);
	}

}
