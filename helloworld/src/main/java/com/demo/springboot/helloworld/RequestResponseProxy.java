package com.demo.springboot.helloworld;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


//Feign makes writing web service (REST)clients easier
	//This annotation tells Spring to create a REST client based on the interface provided.
	//The "reqres-proxy" is an arbitrary client name, which is used by Ribbon load balancer
//@FeignClient(name = "reqres-proxy", url = "http://localhost:8899")
@FeignClient(name = "appconfigrepo")  // to match application service ID If using Eureka Server just provider application name
public interface RequestResponseProxy {

		@RequestMapping(value = "/app-config-repo-dev.properties", method = RequestMethod.GET)
		String getCall();
}	
	
