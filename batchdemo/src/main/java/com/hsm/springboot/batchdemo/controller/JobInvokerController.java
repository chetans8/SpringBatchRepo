package com.hsm.springboot.batchdemo.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
@RequestMapping("/api")
public class JobInvokerController {
 
    @Autowired
    JobLauncher jobLauncher;
 
    @Autowired
    Job job;
   
    
    //JOb can be invoked multiple times by changing parameters of the job or by adding the time parameter to the job
    @RequestMapping("/run-batch-job")
    @Scheduled(fixedRate = 5000)
    public String handle() throws Exception {
 
    	
    	Date date = new Date();
    	DateFormat dateFormat = new SimpleDateFormat("DD/MM/YYYY HH:mm:ss a");
    	String formattedDate=dateFormat.format(date);
    	
    	JobParameters jobParameters = new JobParametersBuilder()
            						.addString("date-time", formattedDate)			//.addString("source", "Spring Boot2")   //addLong("time", System.currentTimeMillis())
           						.toJobParameters();
            jobLauncher.run(job, jobParameters);
    	
            
        return "Batch job has been invoked";
    }
}
