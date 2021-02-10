package com.accenture.dao;

import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.entity.EmployeeEntityBean;

@RepositoryDefinition(idClass=Integer.class,domainClass=EmployeeEntityBean.class)
@Transactional(value="txManager") // name of TransactionManger can be any thing
public interface EmployeeDAO2{
	EmployeeEntityBean save (EmployeeEntityBean en);
	Iterable<EmployeeEntityBean> findAll();
	
}
// this is how to stop exposing all the method