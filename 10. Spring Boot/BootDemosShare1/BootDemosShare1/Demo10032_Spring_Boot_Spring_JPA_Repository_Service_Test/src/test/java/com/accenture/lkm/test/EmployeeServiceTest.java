package com.accenture.lkm.test;

import java.util.Collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.lkm.Application;
import com.accenture.lkm.business.bean.Employee;
import com.accenture.lkm.service.EmployeeServiceImpl;

//Following Annotation is used to tell that SpringJunit is used to run the tests 
@RunWith(SpringJUnit4ClassRunner.class)

// Following Annotation is replacement of @Configuration annotation
// it is used to point to the files having the configuration and helps to load and start the context
// Context will be cached for all test cases and classes
@SpringBootTest(classes=Application.class)

// Following Annotation is used to run each test case in a individual Transaction
// with default strategy as rollback, as service layer is hitting DB layer
// so changes done to database must be undone
@Transactional
public class EmployeeServiceTest {
	private Logger logger = LoggerFactory.getLogger(EmployeeServiceTest.class);

	@Autowired
	private EmployeeServiceImpl empServiceIMPL;

	@Before
	public void testMethodBeforeInterceptor() {
		logger.info("Starting a new Test Method..");
	}

	@After
	public void testMethodAfterInterceptor() {
		logger.info("End the Test Method..");
	}
	
	@Test
	public void testFindAll() {
		Collection<Employee> empList = empServiceIMPL.getEmployeeDetails();
		Assert.assertTrue(empList != null);
	}
	
	@Test
	public void testUpdateInvalid() {

		Employee employee = new Employee("MSD", 10007, 2345.0, 123);
		Employee empUpdated = empServiceIMPL.updateEmployee(employee);
		Assert.assertTrue(empUpdated==null);
	}
	
	@Test
	public void testUpdateValid() {

		Employee employee = new Employee("MSD", 1002, 2345.0, 123);
		Employee empUpdated = empServiceIMPL.updateEmployee(employee);
		Assert.assertTrue(empUpdated!=null);
	}
	@Test
	public void testDeleteInvalid() {
		Employee empDeleted = empServiceIMPL.deleteEmployee(1234);
		Assert.assertTrue(empDeleted==null);
	}
}
