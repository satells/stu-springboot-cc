package com.mudi.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class MudiApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(MudiApplication.class, args);
	}
}