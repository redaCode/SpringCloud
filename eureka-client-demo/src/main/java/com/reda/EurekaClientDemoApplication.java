package com.reda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaClientDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientDemoApplication.class, args);
	}
}
