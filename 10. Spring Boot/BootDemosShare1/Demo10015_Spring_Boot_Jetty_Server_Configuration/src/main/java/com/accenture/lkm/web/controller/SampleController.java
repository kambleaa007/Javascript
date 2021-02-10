package com.accenture.lkm.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
	
	@RequestMapping(value="/getMessage", method=RequestMethod.GET)
	public String getMessage() {
		return "Hello Message";
	}

}
