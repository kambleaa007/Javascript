package com.accenture.ui;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.accenture.dao.EmployeeDAO2;
import com.accenture.entity.EmployeeEntityBean;
import com.accenture.resource.JavaConfig;

public class UITester1 {

	public static void main(String[] args) {
		
		EmployeeDAO2 employeeDAOIMPL=null;
		try{
			
			ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfig.class);
			employeeDAOIMPL = (EmployeeDAO2) applicationContext.getBean("employeeDAO2");
			
		// 1 Add Employee
		addEmployee(employeeDAOIMPL);
		
		// 2 Get All Employees 
		//getAllEmplyeeDetails(employeeDAOIMPL);
		
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	public static void addEmployee(EmployeeDAO2 daoimpl) {

		EmployeeEntityBean bean = new EmployeeEntityBean();
		bean.setInsertTime(new Date());
		bean.setName("New Employee");
		bean.setRole("Sr.Analyst");
		bean.setSalary(10.0);
		
		try {

			int id = daoimpl.save(bean).getId();
			System.out.println("Employee Registered Successfully: " + id);
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}
	
	
	public static void getAllEmplyeeDetails(EmployeeDAO2 daoimpl) {

		EmployeeEntityBean bean = new EmployeeEntityBean();
		bean.setInsertTime(new Date());
		bean.setName("New Employee");
		bean.setRole("Sr.Analyst");
		bean.setSalary(10.0);
		
		try {

			List<EmployeeEntityBean> listEmp  =  (List<EmployeeEntityBean>)daoimpl.findAll();
			listEmp.forEach(emp->{System.out.println(emp.getId()+","+emp.getName()+emp.getRole()+","+emp.getSalary()+","+emp.getInsertTime());
			});
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

}