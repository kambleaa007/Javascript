package com.accenture.lkm.customizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

//Step2: All Customizer should be Spring Components
@Component
@Profile("test_profile")
//Step1: All the Customizers should implement interface EmbeddedServletContainerCustomizer
public class TestCustomizer implements EmbeddedServletContainerCustomizer {

	static private Logger logger =  LoggerFactory.getLogger("TestCustomizer");
	static
	{
		logger.info("********************************************");
		logger.info("Created the Test URL Customizer");
		logger.info("*********************************************");
	}
	// Step3: Override the method customize to override the 
	//default context path and port
	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		container.setContextPath("/spring-boot-test");
		container.setPort(8486);
		
	}

}

