package com.hsm.springboot.batchdemo.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
@EnableBatchProcessing
public class JobInvokerController {
 
    @Autowired
    JobLauncher jobLauncher;
 
    @Autowired
    @Qualifier("accountJob")
    Job accountKeeperJob;
    
    
    //JOb can be invoked multiple times by changing parameters of the job or by adding the time parameter to the job
    @RequestMapping("/run-batch-job")
    @Scheduled(fixedRate = 5000)
    public String handle() throws Exception {
 
            JobParameters jobParameters = new JobParametersBuilder()
            								.addString("source", "Spring Boot")   //addLong("time", System.currentTimeMillis())
            								.toJobParameters();
            jobLauncher.run(accountKeeperJob, jobParameters);
            
        return "Batch job has been invoked";
    }
}
