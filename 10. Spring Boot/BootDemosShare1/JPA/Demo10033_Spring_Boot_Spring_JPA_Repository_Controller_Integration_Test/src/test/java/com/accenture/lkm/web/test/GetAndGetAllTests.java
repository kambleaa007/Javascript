package com.accenture.lkm.web.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.accenture.lkm.Application;
import com.accenture.lkm.business.bean.Employee;
import com.accenture.lkm.web.custom.test.utils.JSONUtils;

//Following Annotation is used to tell that SpringJunit is used to run the tests
@RunWith(SpringJUnit4ClassRunner.class)

//Following Annotation is replacement of @Configuration annotation
//it is used to point to the files having the configuration and helps to load and start the context
//Context will be cached for all test cases and classes
@SpringBootTest(classes=Application.class)

//Following Annotation is used to run each test case in a individual Transaction
//with default strategy as rollback, as service layer is hitting DB layer
//so changes done to database must be undone
@Transactional

//To make the Test Cases WebApplicationContext aware 
@WebAppConfiguration
public class GetAndGetAllTests {

    @Autowired
    WebApplicationContext webApplicationContext; // cached
    
    protected MockMvc mockMVC;
    
    private Logger logger = LoggerFactory.getLogger(GetAndGetAllTests.class);
    
    @Before
    public void mySetup(){
		//making the mockMVC aware of the all the application components
		mockMVC= MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
        
    @Test
    public void getAllEmployeesTest() throws Exception{
    	  String uri="/emp/controller/getDetails";
    	  MockHttpServletRequestBuilder request= MockMvcRequestBuilders.get(uri);
    	  ResultActions rest= mockMVC.perform(request);
    	  MvcResult mvcREsult= rest.andReturn();
		  
    	  //actual status and result
		  String result= mvcREsult.getResponse().getContentAsString();
		  int actualStatus= mvcREsult.getResponse().getStatus();
    	  logger.info(result);
    	  
    	  //As RestControllerProduces Json result, converting from Json to Java Objects
    	  List<Employee> listEmp= JSONUtils.covertFromJsonToObject2(result, List.class);
    	  
    	  //expected status:
    	  int expectedStatus =HttpStatus.OK.value();
    	  
    	  //Testing: Comparing Expected with Actual
    	  Assert.assertTrue(listEmp!=null);
    	  Assert.assertTrue(actualStatus==expectedStatus);	  
    }
    
    
    @Test
    public void getAllEmployeeByIdTest() throws Exception{
    	  String uri="/emp/controller/getDetailsById/1003";
    	  MockHttpServletRequestBuilder request= MockMvcRequestBuilders.get(uri);
    	  ResultActions rest= mockMVC.perform(request);
    	  MvcResult mvcREsult= rest.andReturn();
		   
		  String result= mvcREsult.getResponse().getContentAsString();
		  //actual status and name
		  int statusAct= mvcREsult.getResponse().getStatus();	
		  //As RestControllerProduces Json result, converting from Json to Java Objects
		  Employee emp= JSONUtils.covertFromJsonToObject2(result, Employee.class);
		  
		  
		  //expected status and name
		  String expectedName="Rocky";
		  int statusExp =200;
		  
		  //Testing: Comparing Expected with Actual
    	  Assert.assertTrue(emp.getEmployeeName().equals(expectedName));
    	  Assert.assertTrue(statusAct==statusExp);
    }
    
}