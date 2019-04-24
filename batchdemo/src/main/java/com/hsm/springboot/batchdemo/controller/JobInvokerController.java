package com.hsm.springboot.batchdemo.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
@RequestMapping("/batchdemo")
public class JobInvokerController {
 
    @Autowired
    JobLauncher jobLauncher;
 
    @Autowired
    Job job;
   
   
	@Value("${user.role}")
    private String role;
    
    //JOb can be invoked multiple times by changing parameters of the job or by adding the time parameter to the job and adding annotation @EnableScheduling
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
    	
            
        return "Batch job has been invoked in " + role + " environment";
    }
}
