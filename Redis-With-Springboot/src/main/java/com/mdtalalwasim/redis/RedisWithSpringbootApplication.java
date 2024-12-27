package com.mdtalalwasim.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedisWithSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisWithSpringbootApplication.class, args);
		System.out.println("Start project successfully");
	}

}
