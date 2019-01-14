
package com.hsm.springboot.batch;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
	
	@Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;
    
    @Autowired
    public DataSource dataSource;

    
   /*
    * 
    *  @Bean
    
    public FlatFileItemReader<Provider> reader() {
        return new FlatFileItemReader<Provider>()
            .name(providerItemReader)
            .resource(new ClassPathResource("sample-data.csv"))
            .delimited()
            .names(new String[]{"firstName", "lastName"})
            .fieldSetMapper(new BeanWrapperFieldSetMapper<Provider>() {{
                setTargetType(Provider.class);
            }})
            .build();
    }*/
    
    @Bean
    public FlatFileItemReader<Provider> reader() {
       FlatFileItemReader<Provider> reader = new FlatFileItemReader<Provider>();
       reader.setResource(new ClassPathResource("sample-data.csv"));
       reader.setLineMapper(new DefaultLineMapper<Provider>() {
          {
             setLineTokenizer(new DelimitedLineTokenizer() {
                {
                   setNames(new String[] { "firstName", "lastName","email" });
                }
             });
             setFieldSetMapper(new BeanWrapperFieldSetMapper<Provider>() {
                {
                   setTargetType(Provider.class);
                }
             });
          }
       });
       return reader;
    }
    
    
    @Bean
    public ProviderItemProcessor processor() {
        return new ProviderItemProcessor();
    }
    

    /**
     * @Bean
     * @param dataSource
     * @return
     
    public JdbcBatchItemWriter<Provider> writer(DataSource dataSource) {
        return new JdbcBatchItemWriter<Provider>()
            .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
            .sql("INSERT INTO provider (first_name, last_name) VALUES (:firstName, :lastName)")
            .dataSource(dataSource)
            .build();
    }*/
    
    @Bean
    public JdbcBatchItemWriter<Provider> writer() {
       JdbcBatchItemWriter<Provider> writer = new JdbcBatchItemWriter<Provider>();
       writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Provider>());
       writer.setSql("INSERT INTO PROVIDER (first_name, last_name, email) VALUES (:firstName, :lastName, :email)");
       writer.setDataSource(dataSource);
       return writer;
    }
    // end::readerwriterprocessor[]
    
 // tag::jobstep[]
    @Bean
    public Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
        return jobBuilderFactory.get("importUserJob")
            .incrementer(new RunIdIncrementer())
            .listener(listener)
            .flow(step1)
            .end()
            .build();
    }

    @Bean
    public Step step1(JdbcBatchItemWriter<Provider> writer) {
        return stepBuilderFactory.get("step1")
            .<Provider, Provider> chunk(10)
            .reader(reader())
            .processor(processor())
            .writer(writer)
            .build();
    }
    // end::jobstep[]
    
    @Bean 
    @StepScope
    public Resource destFile(@Value("#{jobParameters[dest]}") String dest) {
        return new FileSystemResource(dest);
    }
    
}
