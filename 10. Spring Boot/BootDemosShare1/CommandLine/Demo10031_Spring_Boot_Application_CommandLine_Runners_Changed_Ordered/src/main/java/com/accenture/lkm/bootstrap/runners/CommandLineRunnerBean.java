package com.accenture.lkm.bootstrap.runners;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class CommandLineRunnerBean implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(CommandLineRunnerBean.class);

	public void run(String... args) {
		String strArgs = Arrays.stream(args).collect(Collectors.joining("|"));
		logger.info("***********************Command Line Runner 1***********************************");
		logger.info("*****Application started with arguments:" + strArgs+"****");
		logger.info("**********************************************************");
	}
}

// CommandLineRunner is an interface that has a method as run( ). 
// To use CommandLineRunner we will create a class and implement it and override its run() method.
// Now annotate this class with spring stereotype such as @Component.
// When the SpringApplication.run() starts the spring boot application
// then just before finishing startup, CommandLineRunner.run() will be executed.
// The run() method of CommandLineRunner accepts the arguments that are passed while starting server.
// It means our service method will run after SpringApplication.run() completes its execution
