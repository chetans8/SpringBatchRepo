package com.hsm.springboot.batchdemonotificationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BatchdemoNotificationserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BatchdemoNotificationserviceApplication.class, args);
	}

}
