package com.accenture.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.accenture.entity.EmployeeEntityBean;



public interface EmployeeDAO3 extends CrudRepository<EmployeeEntityBean, Integer>{
	
	List<EmployeeEntityBean> findBySalaryGreaterThanEqual(double salary);
	
	List<EmployeeEntityBean> findBySalaryGreaterThanEqualOrderByIdDesc(double salary);
	
	List<EmployeeEntityBean> findByNameContainingOrderBySalaryDesc (String pattern);
	
	
	List<EmployeeEntityBean> findBySalaryGreaterThanEqualAndRole(Double param1, String param2);
	
	List<EmployeeEntityBean> findBySalaryBetween(Double param1, Double param2);
	
}

