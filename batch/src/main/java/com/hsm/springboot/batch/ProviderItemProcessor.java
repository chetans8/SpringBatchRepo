package com.hsm.springboot.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;

//Intermediate Processor : Transformed Processor transform data into Upper case only
public class ProviderItemProcessor implements ItemProcessor<Provider, Provider> {

	private static final Logger log = LoggerFactory.getLogger(ProviderItemProcessor.class);
	
	@Override
	public Provider process(final Provider provider) throws Exception {

		final String firstName = provider.getFirstName().toUpperCase();
		final String lastName = provider.getLastName().toUpperCase();
		final String email = provider.getEmail().toUpperCase();
		
		final Provider transformedProvider = new Provider(firstName, lastName, email);
		
		log.info("Converting (" + provider + ") into (" + transformedProvider + ")");
		
		return transformedProvider;
	}

}
