package com.accenture.lkm.dao;


import java.util.Arrays;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.accenture.lkm.bussiness.bean.Employee;

@Profile("test_profile")
@Component
public class EmployeeDAODummyLogs implements EmployeeDAO{

	static private Logger logger =  LoggerFactory.getLogger("EmployeeDAODummyLogs");
	
	//Reading random_var configured in properties file
	@Value("${random_var}")
	private String randomValue;
	
	static
	{
		logger.info("********************************************");
		logger.info("Logging Class loaded: [EmployeeDAODummyLogs]: ");
		logger.info("*********************************************");
	}

	@Override
	public Employee getEmployeeDetailsById(int employeeId) {
		logger.info("From [getEmployeeDetailByEmployeeId] of :["+this.getClass()+"]");
		Employee employee = new Employee();
		employee.setEmployeeName("DummyEmployeeDBDown");
		employee.setSalary(0.0);
		employee.setDepartmentCode(0);
		employee.setEmployeeId(0);
		return employee;
	}


	@Override
	public Collection<Employee> getAllEmployee() {
		logger.info("From [getEmployeeDetails] of :["+this.getClass()+"]");
		logger.info("******************************");
		logger.info("Value of the Random Variable: "+randomValue);
		logger.info("******************************");
		Employee employee = new Employee();
		employee.setEmployeeName("DummyEmployeeDBDown");
		employee.setSalary(0.0);
		employee.setDepartmentCode(0);
		employee.setEmployeeId(0);
		return Arrays.asList(employee);
	}


	@Override
	public Integer addEmployee(Employee employee) {
		logger.info("From [addEmployee] of :["+this.getClass()+"]");
		Employee employee2 = new Employee();
		employee2.setEmployeeName("DummyEmployeeDBDown");
		employee2.setSalary(0.0);
		employee2.setDepartmentCode(0);
		employee2.setEmployeeId(0);
		return 1001;
	}


	@Override
	public Employee updateEmployee(Employee employee) {
		logger.info("From [updateEmployee] of :["+this.getClass()+"]");
		Employee employee2 = new Employee();
		employee2.setEmployeeName("DummyEmployeeDBDown");
		employee2.setSalary(0.0);
		employee2.setDepartmentCode(0);
		employee2.setEmployeeId(0);
		return employee2;
	}

	public Employee removeEmployee(int employeeId) {
		logger.info("From [deleteEmployee] of :["+this.getClass()+"]");
		Employee employee2 = new Employee();
		employee2.setEmployeeName("DummyEmployeeDBDown");
		employee2.setSalary(0.0);
		employee2.setDepartmentCode(0);
		employee2.setEmployeeId(0);
		return employee2;
	}
	

}
