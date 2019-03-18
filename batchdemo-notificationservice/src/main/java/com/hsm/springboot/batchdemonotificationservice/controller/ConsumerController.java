package com.hsm.springboot.batchdemonotificationservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hsm.springboot.batchdemonotificationservice.model.Notification;

@RestController
public class ConsumerController {

	@Autowired
	NotificationService notificationService;
	
	@GetMapping("/hello")
	public String getHelloworld() {
		
		Notification notification = new Notification("Notification is invoked and created", "aa6n1e6l9o5b5l2x0@telushealth.slack.com", "647XXXXX22");
		notificationService.sendNotification(notification);
		
		
		return "Simple Notification Application";
	}
	
	
}
