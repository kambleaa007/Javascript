package com.accenture.lkm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.accenture.lkm.swagger.conf.SwaggerConfig;

@SpringBootApplication
@Import(SwaggerConfig.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


}

//http://localhost:8090/v2/api-docs
//http://localhost:8090/swagger-ui.html
// tell them expand opertions and tell them you can try out fom there it self.. no postman requried
//http://heidloff.net/article/usage-of-swagger-2-0-in-spring-boot-applications-to-document-apis/
//http://www.baeldung.com/swagger-2-documentation-for-spring-rest-api