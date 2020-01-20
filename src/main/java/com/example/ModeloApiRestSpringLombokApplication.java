package com.example;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ModeloApiRestSpringLombokApplication {
	
	 @PostConstruct
     void started() {
       TimeZone.setDefault(TimeZone.getTimeZone("TimeZone"));
     }

	public static void main(String[] args) {
		SpringApplication.run(ModeloApiRestSpringLombokApplication.class, args);

	}
}
