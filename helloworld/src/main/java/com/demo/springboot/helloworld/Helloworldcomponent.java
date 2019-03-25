package com.demo.springboot.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.stereotype.Service;

@Service
@EnableFeignClients
public class Helloworldcomponent {

	@Autowired
	RequestResponseProxy reqresproxy;
	
	public String getExternalCall() {
		System.out.println("Calling External call method");
		int id = 2;
		
		reqresproxy.getCall();
		
		
		
		return " The value of ID returned is " + reqresproxy.getCall();
	}
	
}
