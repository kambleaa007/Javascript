package com.accenture.lkm.web.test;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
//To persist in database comment it
@Transactional

//To make the Test Cases WebApplicationContext aware 
@WebAppConfiguration
public class CreateEmployeeTest {

    @Autowired
    WebApplicationContext webApplicationContext; // cached
    
    protected MockMvc mockMVC;
    
    @Before
    public void mySetup(){
		//making the mockMVC aware of the all the application components
		mockMVC= MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
    
    //Way1: Using MockHttpServletRequestBuilder and MvcResult class
    //Imp methods perform() andReturn()
    @Test
    public void createEmployeeTest() throws Exception{
    	  String uri="/emp/controller/addEmp";
    	  Employee employee = new Employee("Shane",0,90011.1,107);
    	  String employeeJsonFormat =JSONUtils.covertFromObjectToJson(employee);
    	  MockHttpServletRequestBuilder request= MockMvcRequestBuilders.post(uri)
    			  //ResponseContentType: what test case/ test client expects in return
    			  .accept(MediaType.TEXT_HTML) 
    			 
    			  //Data what is sent to server as RequestBody
    			  .content(employeeJsonFormat) 
    			  //Data type of the data being sent to server
    			  .contentType(MediaType.APPLICATION_JSON) ;
    	  
    	  ResultActions rest= mockMVC.perform(request);
    	  MvcResult mvcREsult= rest.andReturn();
		   
		  String finalResult= mvcREsult.getResponse().getContentAsString();
		  int actualStatus = mvcREsult.getResponse().getStatus();
		  
		  Assert.assertTrue(finalResult!=null);
		  Assert.assertTrue(actualStatus==HttpStatus.CREATED.value());
		  
    }
    
    //Way 2 using : MockHttpServletRequestBuilder and 
    //MockMvcResultHandlers and MockMvcResultMatchers class and thier static methods
    //status(), content(), print()
    //Imp Methods : perform(), andDo(), andExpect()
    @Test
    public void createEmployeeTest2() throws Exception{
    	  String uri="/emp/controller/addEmp";
    	  Employee employee = new Employee("Malinga",0,1111.1,1008);
    	  String employeeJsonFormat =JSONUtils.covertFromObjectToJson(employee);
     	 
    	  
    	  MockHttpServletRequestBuilder request= MockMvcRequestBuilders.post(uri)
    			  .accept(MediaType.TEXT_HTML) 
    			  .content(employeeJsonFormat) 
    			  .contentType(MediaType.APPLICATION_JSON) ;
    	  
    	  //MockMvcResultHandlers and MockMvcResultMatchers static methods for Testing
    	  this.mockMVC.perform(request)
    	  .andDo(print()) //for sysouts on console
          .andExpect(status().isCreated()) //201 status code
          .andExpect(content().contentType("text/html;charset=UTF-8"))
          .andExpect(content().string("Employee added successfully with id:1008"));
		  
    }
    
}