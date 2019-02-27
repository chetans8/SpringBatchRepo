package com.hsm.springboot.batchdemoapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class BatchdemoApigatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(BatchdemoApigatewayApplication.class, args);
	}
	
	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
