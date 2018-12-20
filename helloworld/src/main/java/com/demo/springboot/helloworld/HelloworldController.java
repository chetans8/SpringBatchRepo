package com.demo.springboot.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloworldController {

	@GetMapping("/hello")
	public String getHelloworld() {
		
		return "Simple Spring Boot Application";
	}
	
}
