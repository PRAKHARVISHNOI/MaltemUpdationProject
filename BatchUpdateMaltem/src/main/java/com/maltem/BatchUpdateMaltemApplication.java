package com.maltem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BatchUpdateMaltemApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(BatchUpdateMaltemApplication.class, args);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
	}
 
}
