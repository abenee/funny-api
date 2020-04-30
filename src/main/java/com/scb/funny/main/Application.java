package com.scb.funny.main;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan(basePackages={"com.scb.funny"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}