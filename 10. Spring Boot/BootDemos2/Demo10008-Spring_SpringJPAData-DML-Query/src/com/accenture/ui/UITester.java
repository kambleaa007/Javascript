package com.accenture.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.accenture.dao.EmployeeDAO5;
import com.accenture.resource.JavaConfig;

// tell named quereis
public class UITester {

	public static void main(String[] args) {

		EmployeeDAO5 employeeDA2 = null;
		try {

			ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfig.class);
			employeeDA2 = (EmployeeDAO5) applicationContext.getBean("employeeDAO5");
			
			
		    //updateSalary(employeeDA2);
		    
		    //named query update
		    //updateSalary2(employeeDA2);
			
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}

	

	
	
	public static void updateSalary(EmployeeDAO5 daoimpl) {

		int value= daoimpl.updateSalary( 90.0,"James");
		System.out.println("Number of Rows updated are: "+value);

	}
	
	
	public static void updateSalary2(EmployeeDAO5 daoimpl) {

		int value= daoimpl.updateSalary2( "James",190.0);
		System.out.println("Number of Rows updated are: "+value);

	}
	
}
