package com.example.samplesso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"sample_sso"})
public class SampleSsoApplication {

	public static void main(String[] args) {

		SpringApplication.run(SampleSsoApplication.class, args);
	}

}
