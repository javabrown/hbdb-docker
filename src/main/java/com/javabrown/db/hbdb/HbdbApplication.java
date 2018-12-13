package com.javabrown.db.hbdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HbdbApplication {

	public static void main(String[] args) {
	        System.out.println("Docker Ping Test");
 		new DbConnection().testConnection();
		System.out.println("======");
		SpringApplication.run(HbdbApplication.class, args);
	}
}
