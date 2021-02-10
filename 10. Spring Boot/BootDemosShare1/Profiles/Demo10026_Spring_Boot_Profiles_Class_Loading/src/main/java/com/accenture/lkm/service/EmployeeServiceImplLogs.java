package com.accenture.lkm.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("DEV")
@Component
public class EmployeeServiceImplLogs {
	static private Logger logger =  LoggerFactory.getLogger("EmployeeServiceImplLogs");
	static
	{   logger.info("******************************************************************************************************");
		logger.info("Dev profile Class Loading Custom Log[Class loaded: [EmployeeServiceImplLogs]");
		logger.info("******************************************************************************************************");
	}
}