package com.hsm.springboot.batchdemo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.hsm.springboot.batchdemo.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
