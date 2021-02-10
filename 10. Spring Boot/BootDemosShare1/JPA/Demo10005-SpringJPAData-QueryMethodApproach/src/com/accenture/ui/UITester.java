package com.accenture.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.accenture.dao.EmployeeDAO3;
import com.accenture.resource.JavaConfig;

public class UITester {

	public static void main(String[] args) {

		EmployeeDAO3 employeeDA2 = null;
		try {

			ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfig.class);
			employeeDA2 = (EmployeeDAO3) applicationContext.getBean("employeeDAO3");

			getAllEmployeeDetails1(employeeDA2);

			//getAllEmployeeDetails2(employeeDA2);
			
			//getAllEmployeeDetails3(employeeDA2);
			
			//getAllEmployeeDetails4(employeeDA2);
			
			//getAllEmployeeDetails5(employeeDA2);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
	}

	public static void getAllEmployeeDetails1(EmployeeDAO3 daoimpl) {

		try {
			System.out.println(daoimpl.findBySalaryGreaterThanEqual(12.0));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	public static void getAllEmployeeDetails2(EmployeeDAO3 daoimpl) {

		try {

			System.out.println(daoimpl.findBySalaryGreaterThanEqualOrderByIdDesc(30000.0));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}
	
	public static void getAllEmployeeDetails3(EmployeeDAO3 daoimpl) {

		try {

			System.out.println(daoimpl.findBySalaryBetween(10000.0, 50000.0));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

	public static void getAllEmployeeDetails4(EmployeeDAO3 daoimpl) {

		try {

			System.out.println(daoimpl.findByNameContainingOrderBySalaryDesc("a"));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}
	
	
	public static void getAllEmployeeDetails5(EmployeeDAO3 daoimpl) {

		try {

			System.out.println(daoimpl.findBySalaryGreaterThanEqualAndRole(50000.0, "Manager"));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}
	
}
//name of the method is translated into query