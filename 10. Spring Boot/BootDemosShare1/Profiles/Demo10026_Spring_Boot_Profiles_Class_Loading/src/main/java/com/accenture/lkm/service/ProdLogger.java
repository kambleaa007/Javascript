package com.accenture.lkm.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("PROD")
@Component
public class ProdLogger {
	
	static private Logger logger =  LoggerFactory.getLogger("EmployeeServiceImplLogs");
	static
	{   logger.info("******************************************************************************************************");
		logger.info("Prod profile Class Loading Custom Log[Class loaded: [EmployeeServiceImplLogs]");
		logger.info("******************************************************************************************************");
	}

}
