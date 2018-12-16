package com.hsm.springboot.batchdemo.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;


@Entity
public class Users {
	
	@Id
	private Long userId;
	
	@NotNull(message="{name.empty}")
	private String name;
	
	private String dept;
	
	@NotNull(message="{account.empty}")
	//@DecimalMin(value = "0", inclusive = false, message = "{account.invalid}")
	private BigDecimal account;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public BigDecimal getAccount() {
		return account;
	}

	public void setAccount(BigDecimal account) {
		this.account = account;
	}
	
	
}