package com.accenture.lkm.dao;

import java.util.Collection;

import com.accenture.lkm.bussiness.bean.Employee;

public interface EmployeeDAO {
	Collection<Employee> getAllEmployee();
	Employee getEmployeeDetailsById(int id);
	Integer addEmployee(Employee employee);
	Employee updateEmployee(Employee employee);
	Employee removeEmployee(int id);
}