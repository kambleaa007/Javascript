package com.accenture.lkm;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
    	SpringApplication app = new SpringApplication(Application.class);    	
        app.setBannerMode(Banner.Mode.OFF);
        //returns an instance of ConfigurableApplicationContext that can be used to perform normal Spring operations.
        ConfigurableApplicationContext ctx= app.run(args);
        
        
        
    }
}