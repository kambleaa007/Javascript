package com.acc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.accenture.lkm.bussiness.bean.Employee;

@Configuration
public class PrimaryContext {
	
	@Bean
	public Employee createEmp() {
		return new Employee();
	}

}
