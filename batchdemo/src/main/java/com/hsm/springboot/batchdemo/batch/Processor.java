package com.hsm.springboot.batchdemo.batch;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hsm.springboot.batchdemo.entity.Users;
import com.hsm.springboot.batchdemo.repository.UsersRepository;

@Component
public class Processor implements ItemProcessor<Users, Users> {

	private static final Logger logger = LoggerFactory.getLogger(Processor.class);
	
	@Autowired
	private UsersRepository userRepo;

	@Override
	public Users process(Users user) throws Exception {
		
		//System.out.println("User id is ::"+ user.getUserId()+ " ::name : "+user.getName());
		//System.out.println("Amt value ::"+ user.getAccount());
		
		logger.debug("User id is ::"+ user.getUserId()+ " ::name : "+user.getName());
		logger.debug("Amt value ::"+ user.getAccount());
		
		Optional<Users> userFromDb = userRepo.findById(user.getUserId());
		//Optional class information available after job has been invoked.
		if(userFromDb.isPresent()) {
			String TPRID = ""+((int)(Math.random()*9000)+1000);
			user.setAccount(user.getAccount().add(userFromDb.get().getAccount()));
			user.setDept(TPRID);
			//System.out.println("User avaialble"+user);
		}
		return user;
	}

}