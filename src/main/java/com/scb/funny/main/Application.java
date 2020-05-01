package com.scb.funny.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan(basePackages={"com.scb.funny"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}