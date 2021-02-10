package com.accenture.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.entity.EmployeeEntityBean;

@RepositoryDefinition(idClass=Integer.class,domainClass=EmployeeEntityBean.class)
@Transactional(value="txManager") // name of TransactionManger can be any thing
public interface EmployeeDAO4{
	
	@Query("select k from EmployeeEntityBean k where k.salary>=?1")
	List<EmployeeEntityBean> getAllEmployeesBySalary(Double salary); 
	// if more than one parameters are there then sequence of parameters in the method signature should match 
	// with the sequence of parameters in Query
	
	@Query("select k from EmployeeEntityBean k where k.salary>= :sal")
	List<EmployeeEntityBean> getAllEmployeesBySalary2(@Param("sal")Double salary); //Named Parameter
	
	
	@Query("select count(k),k.role from EmployeeEntityBean k group by k.role") 
	List getRolesAndCountOfEmployeesInEachRole();
	// if @query is not having a valid query then 
	// then method signature is checked for the query method
    // query translation 
	
	
}
