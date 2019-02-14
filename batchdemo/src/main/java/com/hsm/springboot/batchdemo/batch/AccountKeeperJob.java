package com.hsm.springboot.batchdemo.batch;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.hsm.springboot.batchdemo.entity.Users;

@Configuration
public class AccountKeeperJob extends JobExecutionListenerSupport {
	
	@Autowired
	JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	StepBuilderFactory stepBuilderFactory;
	
	@Value("${input.file}") 
	Resource resource;
	
	@Autowired
	Processor processor;

	@Autowired
	Writer writer;
	
	@Bean
	public Job processJob() {
		return jobBuilderFactory.get("accountJob")
				.incrementer(new RunIdIncrementer())
				.listener(this)
				.flow(orderStep1())
				.end()
				.build();
	}

	@Bean
	public Step orderStep1() {
		return stepBuilderFactory.get("orderStep1")
				.<Users, Users> chunk(1)
				.reader(new Reader(resource))
				.processor(processor)
				.writer(writer)
				.build();
	}
	
	
	/**@Bean(name = "accountJob")
	public Job accountKeeperJob() {

		Step step = stepBuilderFactory.get("step-1")
				.<Users, Users> chunk(1)
				.reader(new Reader(resource))
				.processor(processor)
				.writer(writer)
				.build();
		
		Job job = jobBuilderFactory.get("accounting-job")
				.incrementer(new RunIdIncrementer())
				.listener(this)
				.start(step)
				.build();

		return job;
	}**/
	
	//This method can be defined in Job Completion Listener as separate class 
	//or This method will provide the status of the job can be defined here
	@Override
	public void afterJob(JobExecution jobExecution) {
		if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
			System.out.println("BATCH JOB COMPLETED SUCCESSFULLY");
		}
	}
			
}