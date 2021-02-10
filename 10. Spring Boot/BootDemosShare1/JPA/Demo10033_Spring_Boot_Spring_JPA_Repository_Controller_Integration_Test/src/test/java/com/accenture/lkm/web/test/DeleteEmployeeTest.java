package com.accenture.lkm.web.test;

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
public class DeleteEmployeeTest {

    @Autowired
    WebApplicationContext webApplicationContext; // cached
    
    protected MockMvc mockMVC;
    
    @Before
    public void mySetup(){
		//making the mockMVC aware of the all the application components
		mockMVC= MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
   @Test
    public void deleteEmployeeTest() throws Exception{
    	  String uri="/emp/controller/deleteEmp/{id}";
    	  										 // check how to pass parameter 
    	                                         // value second way
    	  MockHttpServletRequestBuilder request= MockMvcRequestBuilders.delete(uri,1003)
    		
    			  								// ResponseContentType 
    			                                //what test case/ test client expects in return
    			  								.accept(MediaType.APPLICATION_JSON) ;
    	  
    	  ResultActions rest= mockMVC.perform(request);
    	  MvcResult mvcREsult= rest.andReturn();
		   
		  String finalResult= mvcREsult.getResponse().getContentAsString();
		  int actualStatus = mvcREsult.getResponse().getStatus();
		  
		  //System.out.println(finalResult+", "+actualStatus);
		  Assert.assertTrue(finalResult!=null);
		  Assert.assertTrue(actualStatus==HttpStatus.OK.value());
		  
    }
    
    @Test
    public void deleteInvalidEmployeeTest() throws Exception{
    	  String uri="/emp/controller/deleteEmp/{id}";
    	   										 // check how to pass parameter 
    	                                         // value second way			
    	  MockHttpServletRequestBuilder request= MockMvcRequestBuilders.delete(uri,10006)
    			  							     
								    			  //ResponseContentType 
								                  //what test case/ test client expects in return 
    			  								 .accept(MediaType.APPLICATION_JSON) ;
    	  ResultActions rest= mockMVC.perform(request);
    	  MvcResult mvcREsult= rest.andReturn();
		  String finalResult= mvcREsult.getResponse().getContentAsString();
		  int actualStatus = mvcREsult.getResponse().getStatus();
		  //System.out.println(finalResult+", "+actualStatus);
		  Assert.assertTrue(actualStatus==HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
}