package com.accenture.lkm.web.test;

import static org.junit.Assert.assertTrue;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.lkm.Application;
import com.accenture.lkm.business.bean.Employee;


@RunWith(SpringRunner.class)
@Transactional
//Launch the Spring Boot App on Random Port
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CreateEmpRestTemplate {
	// Autowire the random port into the variable so that we can use it create the
	// url.
	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
	
	@Test
	public void testCreateEmployee() throws JSONException {
		  Employee employee = new Employee("Malinga",0,1111.1,1008);

		HttpEntity<Employee> entity = new HttpEntity<Employee>(employee, headers);

		//rest templace to call the service 
		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/emp/controller/addEmp"),
																	HttpMethod.POST,
																	entity, 
																	String.class);
		
		String expected = "Employee added successfully with id";

		assertTrue("status code mismatch",response.getStatusCode()==HttpStatus.CREATED);
		assertTrue("response content mismatch",response.toString().contains(expected));
	}

	
}
