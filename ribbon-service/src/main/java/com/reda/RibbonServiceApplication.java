package com.reda;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableCaching
@SpringBootApplication
@EnableHystrix
public class RibbonServiceApplication {

	@Bean
	public IRule ribbonRule() {
		return new RandomRule();
	}

	public static void main(String[] args) {
		SpringApplication.run(RibbonServiceApplication.class, args);
	}

}
