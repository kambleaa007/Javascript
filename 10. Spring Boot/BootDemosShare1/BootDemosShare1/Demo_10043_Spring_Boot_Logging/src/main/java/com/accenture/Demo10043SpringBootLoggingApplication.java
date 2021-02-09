package com.accenture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo10043SpringBootLoggingApplication {

	 private static final Logger logger = LoggerFactory.getLogger(Demo10043SpringBootLoggingApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(Demo10043SpringBootLoggingApplication.class, args);
		logger.info("info log");
	      logger.warn("warn log");
	      logger.error("error log");
	}

}
