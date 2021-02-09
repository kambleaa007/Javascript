package com.accenture.lkm.web.test;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.accenture.lkm.Application;
import com.accenture.lkm.business.bean.Employee;
import com.accenture.lkm.controller.EmployeeController;
import com.accenture.lkm.service.EmployeeServiceImpl;
import com.accenture.lkm.web.custom.test.utils.JSONUtils;

//Following Annotation is used to tell that SpringJunit is used to run the tests
@RunWith(SpringJUnit4ClassRunner.class)

//Following Annotation is replacement of @Configuration annotation
//it is used to point to the files having the configuration and helps to load and start the context
//Context will be cached for all test cases and classes
@SpringBootTest(classes=Application.class)
//No @Transactional Required as database is never hit
public class UpdateEmployeeTest {

	//Step1: Declare Service Layer Mocks and inject to Controller
	@Mock
	EmployeeServiceImpl empServiceIMPL;
	// this @mock annotation, instructors the mockito
	// to analyze the class or interface and produce 
	// a test stub (empty methods) with same public methods and signatures
	
	//Step1: Declare Service Layer Mocks and inject to Controller
	@InjectMocks
	EmployeeController controller;
	// this annotation, tells mockito to inject mocked objects
	// into the EmployeeController
	// in our case the empServiceIMPL will be supplied to EmployeeController
		

    
    protected MockMvc mockMVC;
    
    @Before
    public void mySetup(){
    	// this is done to initialize mockito annotations for mocking
    	// prepare the objects for testing
    	MockitoAnnotations.initMocks(this); 
    	
    	//Step2: Using Use MockMvcBuilders to create a MockMvc which is replica just of Controller
    	mockMVC = MockMvcBuilders.standaloneSetup(controller).build();
	}
    @Test
    public void updateEmployeeTest() throws Exception{
    	  String uri="/emp/controller/updateEmp";
    	  Employee employee = new Employee("Jack",1003, 190011.1,102);
    	  String employeeJsonFormat =JSONUtils.covertFromObjectToJson(employee);
    	  //Step3: Use MockHttpServletRequestBuilder to create a request
    	  MockHttpServletRequestBuilder request= MockMvcRequestBuilders.put(uri)
    			  //ResponseContentType what test case/ client expects in return
    			  .accept(MediaType.APPLICATION_JSON)
    			  //RequestBody data what is sent to server
    			  .content(employeeJsonFormat) 
    			  //RequestContentType data type of the data being sent to server
    			  .contentType(MediaType.APPLICATION_JSON);
    	  //Step4: Define the Mocking call for the mocked object created in Step1 and provided to controller 
    	  when(empServiceIMPL.updateEmployee(employee)).thenReturn(employee);

    	  
    	  //Step5: MockMvc created in Step2 will perform() the request created in Step3 and will yield MvcResult
    	  ResultActions rest= mockMVC.perform(request);
    	  MvcResult mvcREsult= rest.andReturn();
		  
    	  //Step6: Extract the actual response content and response status from MvcResult obtained above and 
    	  //compare with the expected response content and expected response status
		  String finalResult= mvcREsult.getResponse().getContentAsString();
		  int actualStatus = mvcREsult.getResponse().getStatus();

		  //Step7: Verify if the Controller is able to delegate the call to the mock
		  verify(empServiceIMPL,times(1)).updateEmployee(employee); 
		  Assert.assertTrue(finalResult!=null);
		  Assert.assertTrue(actualStatus==HttpStatus.OK.value());		  
    }
    
    @Test
    public void updateEmployeeInvalidTest() throws Exception{
  	  String uri="/emp/controller/updateEmp";
  	  Employee employee = new Employee("Jack",0, 190011.1,102);
  	  String employeeJsonFormat =JSONUtils.covertFromObjectToJson(employee);
  	  
  	  //Step3: Use MockHttpServletRequestBuilder to create a request
  	  MockHttpServletRequestBuilder request= MockMvcRequestBuilders.put(uri)
			  //ResponseContentType what test case/ client expects in return
			  .accept(MediaType.APPLICATION_JSON)
			  //RequestBody data what is sent to server
			  .content(employeeJsonFormat) 
			  //RequestContentType data type of the data being sent to server
			  .contentType(MediaType.APPLICATION_JSON);
  	  
  	  //Step4: Define the Mocking call for the mocked object created in Step1 and provided to controller 
  	  when(empServiceIMPL.updateEmployee(employee)).thenReturn(null);
  	  
  	  //Step5: MockMvc created in Step2 will perform() the request created in Step3 and will yield MvcResult
  	  ResultActions rest= mockMVC.perform(request);
  	  MvcResult mvcREsult= rest.andReturn();
	
  	  //Step6: Extract the actual response content and response status from MvcResult obtained above and 
  	  //compare with the expected response content and expected response status
	  String finalResult= mvcREsult.getResponse().getContentAsString();
	  int actualStatus = mvcREsult.getResponse().getStatus();

	  //Step7: Verify if the Controller is able to delegate the call to the mock	  
	  verify(empServiceIMPL,times(1)).updateEmployee(employee); 
	  Assert.assertTrue(finalResult!=null);
	  Assert.assertTrue(actualStatus==HttpStatus.INTERNAL_SERVER_ERROR.value());
  }
    
}