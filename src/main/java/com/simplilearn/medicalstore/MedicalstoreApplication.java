package com.simplilearn.medicalstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class MedicalstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicalstoreApplication.class, args);
	}
	
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
			return new BCryptPasswordEncoder();
	}

}
