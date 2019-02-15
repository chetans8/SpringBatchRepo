package com.hsm.springboot.batchdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class BatchdemoApplication {

	private static final Logger logger = LoggerFactory.getLogger(BatchdemoApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(BatchdemoApplication.class, args);
		logger.debug("--Application Started--");
	}
}
