# Web Services

[Web Services] Important Notes

## [Just Web Services] 09. Web Services

### Web Services
A Beginner’s Guide To Web Services

API is to backend as UI is to frontend

when you hear someone say "API", most of the time they're referring to REST. The name is fancy, but it's mostly referring to making CREATE/READ/UPDATE/DELETE requests over HTTP using JSON as the format

CRUD is just a way of organizing the actions that can be done to resources, it can be done over other types of API too, for example RPC. So REST would be more like "CRUD-over-HTTP-with-JSON-payloads"

"Client-server" is a consequence of using HTTP; "Request isolation", and to some extent "Cacheable" are consequence of it being Stateless; "Uniform" is a property of all APIs

A RESTful API is an API that follows the principles of REpresentational State Transfer.

It:
- embraces a client-server architecture
- is stateless
- is cacheable
- has a uniform interface
- is a layered system

REST != HTTP
REST and HTTP are not same !!

HTTP is first and foremost a protocol to transfer data.

RESTis a set of constraints that CAN use HTTP. Smiling face with smiling eyes

### Architectural Style - how do we organize our code / a manner of doing something
### Architectural Patterns - how a solution can be used to solve a reoccurring problem.
### Design Patterns - best practices and experiences that software professionals used over the years to solve the general problem by – trial and error – they faced during software development.



### REST

If services will be consumed by a web browser internet application, mobile application (when processing power is 'low') 
I will choose REST, as the communication is being made in json format which is more friendly with javascript technologies and the processing and parsing time is less than XML.
When services will expose the data as part of a simple API giving access to the user to do CRUD operations, 
or when not much business logic is involved in the processes. I will choose REST too if I have to build a public API.
If time is in play, implementation of REST is simpler than SOAP. As there are no standards you don't need to have contracts. 
There are some best practices, but at the end you could use HTTP verbs as you want and create URI style in the way you prefer, but having this much flexibility will make you at some point start doing a kind of RPC API instead of a resource API (remeber REST is more about resources).
Take advantage of cache provide by http GET verb in browsers, 
if the purpose of your service is expose information on web page app.
From a developer's perspective, which is always important, 
it is faster to build these kind of services. You just need to know a framework that supports REST, such as JAX-RS, Spring REST, Jersey, and some notions of JSON. The learning curve is also smaller.
It is a lightweight form of transport information, and it is faster as it doesn't require extensive processing.

### SOAP

Have contracts that defines the communication within the services, you will be tied to this contract and your clients must follow it too. Any change in this contract will impact all your clients. 
You must always document what contracts you must use for your operations.
Have interesting standards that can work in the system integration as WS-Interoperability, WS-addressing, WS-security, so basically is a technology that have several standards which makes easier the phase of agreement, not always the implementation.
Can be used with different transport layer smtp, http, if you want to have different kind of clients.
Good standard to transport binary data MTOM/XOP or SwA. If prefer this one to send the bytes in the body of a PUT request.
Better definition of security and integrity, a lot of options comming from the standards, normally the more used in REST is OAuth.
From the developer perspective this will take more time to learn and also you need to have at least very basic knowledge of XSD, XPath, WSDL and other concepts. In some situations following the standards is not always easy. You have good tools and frameworks to build them JAX/WS, Spring-ws, CXF.

### SOA (Service oriented architecture) - Building software out of widgets.

- as the name suggests that it is combination of services. These services are loosly coupled and interacts with each other to provide a solution. Services may be RESTful web service to carry out some function.

- I think the name is self-explanatory in this case: SOA -- which stands for Service Oriented Architecture -- refers to architectures designed with a focus on services. Now, the tricky part here is what you may or may not consider a service and that is a whole different topic.

- is a subtype of architectures and hence a structural view of some components and their relationships, where happens to be services and communications between those services respectively.




### Microservices -  Building software out of small widgets.

- Again as the name suggests micro services. The idea behind microservices is that it becomes easier to build and maintain some type of services when they are broken down into smaller, composable pieces that work together.

- are a subtype of services specialized by minimal responsibility.



### Webservices -  Makes widgets look like the internet

- A service (some functionality like checking seat availability in a train) available on web is known as web service. Such services communicate over the WWW using HTTP.

- This accounts for the subset of SOA using web-related technologies. This typically involves HTTP and XML but it could also use FTP. I think the term web here is quite vague as it generally refers to standard Internet technologies.

- are a subtype of services as well, specialized by the type of service they provide wich fall under web requirements and needs.




### REST - Makes widgets look a lot like the internet

- It is just an architectural style for designing webservices.

- REST is a subset of web services -- and hence a SOA -- that revolves around using HTTP for communication. There are a certain set of common practices such as a certain given relevance to URLs.

- is a subtype of communication, underlying http protocol.



### REST(ful) - Implementations of a REST architectural style are said to be RESTful.

- is a subtype of architectures (a structural view of some components and their relationships) where specialized by relationships among components restricted to be rest communications.

- RESTful was presented to me as a more strict REST implementation where a resource would have a unique URI and it would be managed through CRUD operations mapped to HTTP verbs -- Create = POST, Read = GET, Update = PUT, Delete = Delete.

- Updating user information through a HTTP GET or POST request o a /users/1/update URL would be perfectly valid in REST, but it would not be RESTful. 
For the latter, the approach would be to use an HTTP PUT or PATCH over /users/1 (which would also be the URL for the rest of the operations, simply varying the HTTP verb).

- Constraints of RESTful API
    - Uniform Interface
    - Stateless
    - Cacheable
    - Client-Server (SEPARATION OF CLIENT AND SERVER)
    - Layered System
    - Code on Demand

- Uniform Interface: It is a key constraint that differentiate between a REST API and Non-REST API. It suggests that there should be an uniform way of interacting with a given server irrespective of device or type of application (website, mobile app).
There are four guidelines principle of Uniform Interface are:
    - Resource-Based: Individual resources are identified in requests. For example: API/users.
    - Manipulation of Resources Through Representations: Client has representation of resource and it contains enough information to    modify or delete the resource on the server, provided it has permission to do so. Example: Usually user get a user id when user request for a list of users and then use that id to delete or modify that particular user.
    - Self-descriptive Messages: Each message includes enough information to describe how to process the message so that server can easily analyses the request.
    - Hypermedia as the Engine of Application State (HATEOAS): It need to include links for each response so that client can discover other resources easily.

- Stateless: It means that the necessary state to handle the request is contained within the request itself and server would not store anything related to the session. In REST, the client must include all information for the server to fulfill the request whether as a part of query params, headers or URI. Statelessness enables greater availability since the server does not have to maintain, update or communicate that session state. There is a drawback when the client need to send too much data to the server so it reduces the scope of network optimization and requires more bandwidth.

- Cacheable: Every response should include whether the response is cacheable or not and for how much duration responses can be cached at the client side. Client will return the data from its cache for any subsequent request and there would be no need to send the request again to the server. A well-managed caching partially or completely eliminates some client–server interactions, further improving availability and performance. But sometime there are chances that user may receive stale data.

- Client-Server: REST application should have a client-server architecture. A Client is someone who is requesting resources and are not concerned with data storage, which remains internal to each server, and server is someone who holds the resources and are not concerned with the user interface or user state. They can evolve independently. Client doesn’t need to know anything about business logic and server doesn’t need to know anything about frontend UI.

- Layered system: An application architecture needs to be composed of multiple layers. Each layer doesn’t know any thing about any layer other than that of immediate layer and there can be lot of intermediate servers between client and the end server. Intermediary servers may improve system availability by enabling load-balancing and by providing shared caches.

- Code on demand: It is an optional feature. According to this, servers can also provide executable code to the client. The examples of code on demand may include the compiled components such as Java applets and client-side scripts such as JavaScript.


#### Rules of REST API: There are certain rules which should be kept in mind while creating REST API    

- REST is based on the resource or noun instead of action or verb based. It means that a URI of a REST API should always end with a noun. Example: /api/users is a good example, but /api?type=users is a bad example of creating a REST API.
- HTTP verbs are used to identify the action. Some of the HTTP verbs are – GET, PUT, POST, DELETE, UPDATE, PATCH.
- A web application should be organized into resources like users and then uses HTTP verbs like – GET, PUT, POST, DELETE to modify those resources. And as a developer it should be clear that what needs to be done just by looking at the endpoint and HTTP method used.
- Always use plurals in URL to keep an API URI consistent throughout the application.
- Send a proper HTTP code to indicate a success or error status.

#### HTTP verbs: Some of the common HTTP methods/verbs are described below:

- GET: Retrieves one or more resources identified by the request URI and it can cache the information receive.
- POST: Create a resource from the submission of a request and response is not cacheable in this case. This method is unsafe if no security is applied to the endpoint as it would allow anyone to create a random resource by submission.
- PUT: Update an existing resource on the server specified by the request URI.
- DELETE: Delete an existing resource on the server specified by the request URI. It always return an appropriate HTTP status for every request.

#### GET, PUT, DELETE methods are also known as Idempotent methods. Applying an operation once or applying it multiple times has the same effect. Example: Delete any resource from the server and it succeeds with 200 OK and then try again to delete that resource than it will display an error message 410 GONE.



We can think like this:- 
SOA is having some services. These services are combination of microservices. Those microservices are exposed as webservices and the webservices are build on REST.

I'd say that all these terms fall into the `umbrella of Service Oriented Architectures (SOA)` 
Web services is a SOA using web-related technologies. REST and its subset RESTful are a set of practices to implement web services. Finally, microservices are a new set of SOA practices.

