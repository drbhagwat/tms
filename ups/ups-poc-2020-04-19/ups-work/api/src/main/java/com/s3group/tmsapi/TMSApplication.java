package com.s3group.tmsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.s3group.tmsapi.*")
public class TMSApplication {
	public static void main(String[] args) {
		SpringApplication.run(TMSApplication.class, args);
	}
}
