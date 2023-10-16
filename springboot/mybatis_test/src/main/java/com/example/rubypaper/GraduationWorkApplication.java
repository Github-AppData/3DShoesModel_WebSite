package com.example.rubypaper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class GraduationWorkApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraduationWorkApplication.class, args);
	}

}
