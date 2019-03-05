package com.hsm.springboot.batchdemonotificationservice.config;

import org.springframework.cloud.stream.annotation.EnableBinding;

import com.hsm.springboot.batchdemonotificationservice.stream.NotificationStreams;

@EnableBinding(NotificationStreams.class)
public class StreamsConfig {

}