package com.accenture.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.accenture.entity.EmployeeEntityBean;

public interface EmployeePagedDAO extends PagingAndSortingRepository<EmployeeEntityBean, Integer>{
	
	
	

}

