package com.accenture.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.entity.EmployeeEntityBean;

// Mandatory to give this other wise code will not run in a transaction
@Transactional(value="txManager")
public interface EmployeeDAO5 extends CrudRepository<EmployeeEntityBean, Integer>{
	// Focus on below:
	@Modifying //  if you don't write this(@Modifying) then you will get an exception DMl operation not supported
	@Query(name="EMP.query4_update_salary")
	public int updateSalary(Double salary,String name);
	
	@Modifying //  if you don't write this(@Modifying) then you will get an exception DMl operation not supported
	@Query(name="EMP.query5_update_salary")
	public int updateSalary2(@Param("empName")String name,@Param("newSal") Double salary);
	
}