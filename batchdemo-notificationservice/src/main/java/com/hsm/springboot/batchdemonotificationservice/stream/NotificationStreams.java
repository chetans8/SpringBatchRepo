package com.hsm.springboot.batchdemonotificationservice.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface NotificationStreams {
	
	String INPUT = "notification-in";
    String OUTPUT = "notification-out";
    
    @Input(INPUT)
    SubscribableChannel subscribe();
    
    @Output(OUTPUT)
    MessageChannel notifyTo();

}