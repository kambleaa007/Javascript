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
parent starter  (basic starter)            
child starter (your given)      

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


@Configuration          
@ComponentScan          
@EnableAutoConfiguration            



SpringApplication is Class      
-> run method       
-> pass classname, cmd args[]           

* bootstrap
* create ApplicationContext instance ->spring container IoC DI
* trigger CommandLineRunner beans
* app.properties file --> read

SpringApplication app = new (MyApplication.class)
app.setBannerMode(Banner.Mode.OFF)

ConfigurabeApplicationContext ctx = app.run(args) // return app context


### Builder Pattern
simplify way Object Creation
keep adding things

ClassObject obj = new ClassObject()
                        .addOne()
                        .addTwo()
                        .addThree(); 




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

### JPA

Building JPA Container EntityManagerFactory

### Custom JPA Query

remove extends CRUDRepo or JPARepo

add annotations             

@RepositoryDefinition(idClass=Integer,domainClass=Entity)           
@Transactional  


@Query("JPQL")          
@Query("SQL", nativeQuery=true)         


@Modifying


### Query Methods

fixed keywords Supported Query Keywords
name of method gets translated into query

findBy --> select query



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


### Profiles

````
@Profile("DEV")
@Component
class DevClassLogger{

}
````

> app.prop
> spring.profiles.active=DEV

### load programmatic

````
ConfigurableEnvironment env = new StandardEnv();
env.setActiveProfiles("DEV");

app.setEnvironment(env);
````

### properties files



### Customised

````

@Component
@Profile("QA")
class impl EmbeddedServeletContainerCustomizer{

    @Override
    customize(ConfigurableEmbeddedServletContainer cont){
        cont.setContextPath("/MyApp")
        cont.setPort(8090)
    }

}

````

### CommandLineRunner

````
    @Order(1)
    @Component
    class impl CommandLineRunner
    {

        @Override
        run(){
            
        }

    }

    @Order(1)
    @Component
    class impl ApplicationRunner
    {

        @Override
        run(ApplicationArguments args){
            
        }

    }


````

Run as run arguments
Spring Bott App --> Multiple Instances Running
Running app --> on port 8080 
You need one more instance --> run arguments --> server.port=8091           
You need one more instance --> run arguments --> server.port=8092       
three instances running         
8080 8091 8092      

You need one more instance --> run arguments --> server.port=8093 -Dspring.profiles.active=DEV           
You need one more instance --> run arguments --> server.port=8094 -Dspring.profiles.active=QA
       
five instances running         
8080 8091 8092 8093(DEV) 8094(QA)      


### Logging

LogBack File --> logback.xml

app.prop -->

logging.file=myLog.log
logging.path=/
logging.level.com.acc=INFO


### Actuators
Run on different port
Production Ready Features, Monitoring

Enable Endpoints
management.security.enabled=false

HAL Browser --> UI <dependency spring-data-rest-hal-browser>


### RestTemplate

Consume services

````

RestTemplate rt = new RestTemplate() 
String str = rt.getForObject("URL", String.class)

ResponseEntity<Employee> e = rt.getForEntity("", Employee.class)

rt.exchange("URL",HTTPMETHOD.GET, Employee.class)

````

### Testing

@SpringBootTest(classes=Application.class)
--> Starting up Application class --> return context     


@Transactional    // rollback DB testing entries
class Service{

}

// to make test class aware webappcontext
@WebAppConfiguration        // we need web based context
class TestClass{

    @Autowired
    WebApplicationContext ctx;

    MockMvc mock;

    @Before
    mySetup(){
        mock = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    getAllEmployeesTest(){

    }

}





### Packaging

<package>war</package>
No Embedded Server --> need TomCat installed on server
for JAR --> ( no need to deploy WAR files as embedded server are there )



@Cacheable --> spring in memory 








