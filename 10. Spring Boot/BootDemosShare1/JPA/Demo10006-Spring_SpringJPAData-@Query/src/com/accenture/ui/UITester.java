package com.accenture.ui;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.accenture.dao.EmployeeDAO4;
import com.accenture.resource.JavaConfig;

public class UITester {

	public static void main(String[] args) {

		EmployeeDAO4 employeeDA2 = null;
		try {

			ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfig.class);
			employeeDA2 = (EmployeeDAO4) applicationContext.getBean("employeeDAO4");
			//getAllEmployeeDetails1(employeeDA2);
			getAllEmployeeDetails2(employeeDA2);
		    //getAllEmployeeDetails3(employeeDA2);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


	public static void getAllEmployeeDetails1(EmployeeDAO4 daoimpl) {

		try {

			System.out.println(daoimpl.getAllEmployeesBySalary(50000.0));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}
	
	public static void getAllEmployeeDetails2(EmployeeDAO4 daoimpl) {

		try {

			List list=daoimpl.getRolesAndCountOfEmployeesInEachRole();
			
			for(Object obj:list)
			{
				Object[]  objArray = (Object[])obj;
				System.out.println(objArray[0]+","+objArray[1]);
				
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}
	
	
	public static void getAllEmployeeDetails3(EmployeeDAO4 daoimpl) {
		try {
			System.out.println(daoimpl.getAllEmployeesBySalary2(50000.0));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
}