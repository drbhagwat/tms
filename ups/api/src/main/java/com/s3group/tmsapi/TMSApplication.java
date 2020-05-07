package com.s3group.tmsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.s3group.tmsapi.*")
@EnableJpaRepositories
public class TMSApplication {
	public static void main(String[] args) {
		SpringApplication.run(TMSApplication.class, args);
	}
}
