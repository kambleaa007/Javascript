package com.acc;

import org.springframework.web.client.RestTemplate;

public class RestClientDemo {
	
	public static void main(String[] args) {
		
		RestTemplate template= new RestTemplate();
		String s = template.getForObject("https://quotes.rest/qod", String.class);
		System.out.println(s);
		
		String s1 = template.getForObject("http://localhost:8091/bikes/all", String.class);
		System.out.println(s1);
	}

}
