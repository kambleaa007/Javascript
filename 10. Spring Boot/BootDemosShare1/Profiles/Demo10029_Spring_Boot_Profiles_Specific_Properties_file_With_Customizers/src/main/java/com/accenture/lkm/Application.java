package com.accenture.lkm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.StandardEnvironment;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
    	ConfigurableEnvironment environment =  new StandardEnvironment();
    	environment.setActiveProfiles("test_profile");
    	
        SpringApplication app = new SpringApplication(Application.class);
        app.setEnvironment(environment);
        
        app.run(args);
        
    }
}