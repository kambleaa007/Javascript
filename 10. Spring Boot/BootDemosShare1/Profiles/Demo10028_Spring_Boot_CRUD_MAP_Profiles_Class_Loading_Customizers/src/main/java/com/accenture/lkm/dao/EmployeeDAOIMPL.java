package com.accenture.lkm.dao;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.accenture.lkm.bussiness.bean.Employee;

@Repository
@Profile("prod_profile")
public class EmployeeDAOIMPL implements EmployeeDAO {
	
	static private Logger logger =  LoggerFactory.getLogger("EmployeeDAOIMPLActual");

	static public Map<Integer, Employee> mapOfEmloyees = new LinkedHashMap<Integer, Employee>();
	static int count=10004;
	static
	{
		mapOfEmloyees.put(10001, new Employee("Jack",10001,12345.6,1001));
		mapOfEmloyees.put(10002, new Employee("Justin",10002,12355.6,1002));
		mapOfEmloyees.put(10003, new Employee("Eric",10003,12445.6,1003));
		logger.info("********************************************");
		logger.info("Logging Class loaded: [EmployeeDAOIMPLActual]");
		logger.info("*********************************************");
	}
	public Collection<Employee> getAllEmployee(){
		return mapOfEmloyees.values();			
	}
	
	
	public Employee getEmployeeDetailsById(int id){
		return mapOfEmloyees.get(id);
	}
	
	public Integer addEmployee(Employee employee){
		count++;
		employee.setEmployeeId(count);
		mapOfEmloyees.put(count, employee);
		return count;
	}
	
	public Employee updateEmployee (Employee employee){
		mapOfEmloyees.put(employee.getEmployeeId(), employee);
		return employee;
	}
	
	
	public Employee removeEmployee (int id){
		Employee emp= mapOfEmloyees.remove(id);
		return emp;
	}
	
}
