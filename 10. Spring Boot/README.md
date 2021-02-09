# Spring Boot

[Spring Boot] Important Notes

## [Spring Boot] 10. Spring Boot

### Spring Boot 5

Reactive 
Serverless

### Microservices

Monolith drawback 
modify quickly releases multiple times
expectation clents changed
freq chgs faster releses
scaling with more users more inst of app


Heroku 1st by Adam
### 12 factor principle
spring boot -> microserv
adrian cockroft at netflix -> fince grained SOA

install puttyGen

pom
parent starter
child starter

embedded tomcat server provided by dependency
plugin ->fat jar-> deployable artifact-> bigger size->controller->spring rest->annotation


spring boot -> autoconfig
app.prop
key value data

debug=true

### AutoConfiguration
auto config app by jar dependencies added_. look at jar class path-> auto config

Importing additional configuration classes   
@Import or @ComponentScan

Importing XML configuration   
@ImportResource to load XML config files 


// Primary configuration/runner class
@SpringBootApplication->combines three

SpringApplication is Class
-> run method
-> pass classname, cmd args[]

@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan


@EnableAutoConfiguration->combine
@Configuration
this is spring core, imp config class
xml replacement beans
manually in web.xml
-> started DispactureServlet

spring-boot-starter ->dependency

### How Run

1)
run as java app
run as spring app

2)
package -> jar -> run jar
java -jar `SNAPSHOT.jar`

maven
maven build...
goal -> package

building jar-> target folder-> Fat JAR
project + embed server + libs

.jar.original -> lightweight

got .jar
run on cmd> java -jar `name of .jar`



3)
mvn spring-boot:run

### Tom cat initialised on port???

only when
spring-boot-starter-web
not for plain java
spring-boot-starter

web project run on web servers

serverless containerless app

Web Server-> Tomcat Server-> Container Deployment -> have ->App

App deployment

I want jetty server?

<exclusion>
    spring-boot-starter-tomcat
</exclusion>
spring-boot-starter-jetty

### Root URL 
server.servlet.context-path=/myapp

### Spring 

Spring MVC-> has Spring REST (no views)

better use-> Spring Data JPA

complex are->
Spring JDBC
Spring JPA

minimum config and faster

spring-boot-starter-data-jpa

mysql
mysql-connector-java



