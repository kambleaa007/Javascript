package com.accenture.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;

import com.accenture.entity.EmployeeEntityBean;

//Either use the following or Extend from CrudRepository
@RepositoryDefinition(idClass=Integer.class,domainClass=EmployeeEntityBean.class)
public interface EmployeeDAO4{
	@Query(name="EMP.query1_getAllEmployeesStringFunctions")
	List stringFunctions(); 
	
	@Query(name="EMP.query3_getAverageSalaryForEmployeesByRole") 
	List groupByExampleNamed();
	
}