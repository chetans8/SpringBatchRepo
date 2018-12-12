package com.hsm.springboot.batchdemo.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.hsm.springboot.batchdemo.entity.Users;
import com.hsm.springboot.batchdemo.repository.UsersRepository;



@Component
public class Writer implements ItemWriter<Users>{
	
	@Autowired
	private UsersRepository repo;

	@Override
	@Transactional
	public void write(List<? extends Users> users) throws Exception {
		repo.saveAll(users);
	}
	
}