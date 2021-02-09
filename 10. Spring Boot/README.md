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

1) run as java app      
run as spring app

2)package -> jar -> run jar         
java -jar `SNAPSHOT.jar`

maven               
maven build...              
goal -> package     

building jar-> target folder-> Fat JAR          
project + embed server + libs           

.jar.original -> lightweight                

got .jar            
run on cmd> java -jar `name of .jar`            

3) mvn spring-boot:run

### Tom cat initialised on port???

only when               
spring-boot-starter-web     
not for plain java      
spring-boot-starter     

web project run on web servers          

serverless containerless app

Web Server-> Tomcat Server-> Container Deployment -> have ->App         

App deployment          

### I want jetty server?

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

### Entity vs Bean

Entity --> Represents Table             
NEVER USE OR RETURN TABLE ALWAYS        
NEVER EXPOSE DIRECTLY       

Create Bean --> POJO            
NO annotation like @Id          

DAO --> works on Entity         
interface StudentDAO extends crudRepo<StudentEntity, INTERGER>          


### controller 

Use Bean here           
return--> ResponseEntity<Bean> --> body, status         



### Custom JPA Query

remove extends CRUDRepo or JPARepo

add annotations             

@RepositoryDefinition(idClass=Integer,domainClass=Entity)           
@Transactional  


@Query("JPQL")          
@Query("SQL", nativeQuery=true)         


Annotation |	Meaning
---------- | ------------
@Component |	generic stereotype for any Spring-managed component
@Repository	| stereotype for persistence layer
@Service |	stereotype for service layer
@Controller |	stereotype for presentation layer (spring-mvc)


> @Service, @Controller, @Repository = {@Component + some more special functionality}

### Spring bean scopes example

In Spring, bean scope is used to decide which type of bean instance should be return from Spring container back to the caller.          

5 types of bean scopes supported :          

* singleton – Return a single bean instance per Spring IoC container
* prototype – Return a new bean instance each time when requested
* request – Return a single bean instance per HTTP request. *
* session – Return a single bean instance per HTTP session. *
* globalSession – Return a single bean instance per global HTTP session. *

In most cases, you may only deal with the Spring’s core scope – singleton and prototype, and the default scope is singleton.            

P.S * means only valid in the context of a web-aware Spring ApplicationContext




