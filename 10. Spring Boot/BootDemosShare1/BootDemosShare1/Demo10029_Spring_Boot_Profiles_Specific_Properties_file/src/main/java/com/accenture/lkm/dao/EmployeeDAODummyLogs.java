package com.accenture.lkm.dao;


import java.util.Arrays;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.accenture.lkm.bussiness.bean.Employee;

@Profile("test_profile")
@Repository
public class EmployeeDAODummyLogs implements EmployeeDAO{

	private static Logger logger =  LoggerFactory.getLogger("EmployeeDAODummyLogs");
	
	static{
		logger.info("********************************************");
		logger.info("Logging Class loaded: [EmployeeDAODummyLogs]: ");
		logger.info("*********************************************");
	}

	@Override
	public Employee getEmployeeDetailsById(int employeeId) {
		Employee employee = new Employee();
		employee.setEmployeeName("DummyEmployeeDBDown");
		employee.setSalary(0.0);
		employee.setDepartmentCode(0);
		employee.setEmployeeId(0);
		return employee;
	}


	@Override
	public Collection<Employee> getAllEmployee() {
		Employee employee = new Employee();
		employee.setEmployeeName("DummyEmployeeDBDown");
		employee.setSalary(0.0);
		employee.setDepartmentCode(0);
		employee.setEmployeeId(0);
		return Arrays.asList(employee);
	}


	@Override
	public Integer addEmployee(Employee employee) {
		Employee employee2 = new Employee();
		employee2.setEmployeeName("DummyEmployeeDBDown");
		employee2.setSalary(0.0);
		employee2.setDepartmentCode(0);
		employee2.setEmployeeId(0);
		return 1001;
	}


	@Override
	public Employee updateEmployee(Employee employee) {
		Employee employee2 = new Employee();
		employee2.setEmployeeName("DummyEmployeeDBDown");
		employee2.setSalary(0.0);
		employee2.setDepartmentCode(0);
		employee2.setEmployeeId(0);
		return employee2;
	}

	public Employee removeEmployee(int employeeId) {
		Employee employee2 = new Employee();
		employee2.setEmployeeName("DummyEmployeeDBDown");
		employee2.setSalary(0.0);
		employee2.setDepartmentCode(0);
		employee2.setEmployeeId(0);
		return employee2;
	}
}
