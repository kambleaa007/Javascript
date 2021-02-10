package com.accenture.lkm;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.acc.PrimaryContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
    	SpringApplicationBuilder app = new SpringApplicationBuilder()
    									.sources(Application.class)
    									.bannerMode(Banner.Mode.OFF)
    									.parent(PrimaryContext.class);
    								
        //returns an instance of ConfigurableApplicationContext that can be used to perform normal Spring operations.
        ConfigurableApplicationContext ctx= app.run(args);
        
        
    }
}