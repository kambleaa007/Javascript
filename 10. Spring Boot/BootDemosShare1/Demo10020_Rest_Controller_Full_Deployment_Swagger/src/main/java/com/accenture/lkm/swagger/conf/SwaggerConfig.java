package com.accenture.lkm.swagger.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build().apiInfo(apiInfo());
	}

	// custom API info
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring REST Sample with Swagger")
                .description("Spring REST Sample with Swagger")
                .termsOfServiceUrl("http://www-03.ibm.com/software/sla/sladb.nsf/sla/bm?Open")
                .contact(new Contact("LKM", "LKM", "LKM@123"))
                .license("LKM Liences")
                .licenseUrl("LKM.com")
                .version("2.0")
                .build();
    }
}

/*
 * Swagger 2 is enabled through the @EnableSwagger2 annotation.
 * 
 * After the Docket bean is defined, its select() method returns an instance of
 * ApiSelectorBuilder, which provides a way to control the endpoints exposed by
 * Swagger.
 * 
 * Predicates for selection of RequestHandlers can be configured with the help
 * of RequestHandlerSelectors and PathSelectors. Using any() for both will make
 * documentation for your entire API available through Swagger.
 * 
 * This configuration is enough to integrate Swagger 2 into existing Spring Boot
 * project.
 */
