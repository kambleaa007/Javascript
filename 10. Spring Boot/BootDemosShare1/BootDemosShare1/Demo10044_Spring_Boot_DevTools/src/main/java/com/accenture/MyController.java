package com.accenture;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//change this file and observe restarted main thread 
//log in console and see spring boot start up again
@Controller
public class MyController {
	
	@RequestMapping("gotopage")
	public String openmypage() {
		System.out.println("fdsfdsf change");
		return "mypage2.html";
	}
}
