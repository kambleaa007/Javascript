package com.accenture.lkm.web.test;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.accenture.lkm.Application;

@RunWith(SpringRunner.class)
//Launch the Spring Boot App on Random Port
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GetEmpUsingRestTemplateRandomPort {

	//Autowire the random port into the variable so that we can use it create the url.
	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();
	
	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

	@Test
	public void testGetEmployee() throws JSONException {

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		//rest templace to call the service 
		//Utility method to create the url given an uri. It appends the port.
		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/emp/controller/getDetailsById/1003"),
				HttpMethod.GET, entity, String.class);
		
		String expected = "{\"employeeName\":\"Rocky\",\"employeeId\":1003,\"salary\":100000.0,\"departmentCode\":102}";

		//JsonAssert class provides am easy way to test response
		JSONAssert.assertEquals(expected, response.getBody(), false);
	}

	
}
