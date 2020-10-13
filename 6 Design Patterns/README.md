# Project

[DesignPatterns] Important Design Patterns

## [Just Design Patterns] 06. Design Patterns

### 

### What is Pattern:

“Each pattern describes a problem which occurs over and over again in our environment, and then describes the core of the solution to that problem, in a way that you can use this solution a million times over, without ever doing it the same way twice.”
— Christopher Alexander     

Are Design Patterns and Architecture Patterns same?             
No, Architecture of an application refers to the larger structure of application while a design pattern refers to a method of solving a specific type of problem, much more focused and lower level than the global structure of the system.

##### Architecture focuses on the abstract view of idea while design focus on the implementation view of idea.

#### A Pattern has four elements:        
1) Pattern name - It’s a handle we use to describe a problem, solution and it’s consequences. It lets us design at a higher level of abstraction.           
2) Problem - Problem describes when to apply the pattern, it explains the problem and it’s context. It may include a list of conditions that must be met before it makes sense to apply the pattern.            
3) Solution - The solution describes the elements [object or class] that make up the design, their relationships, responsibilities, and collaborations. The solution doesn’t describe a particular concrete design, because a pattern is like a template that can be applied in many different situations. Instead, the pattern provides an abstract description of a design problem.           
4) Consequences - The consequences are the trade-offs of applying the pattern. They are critical for evaluating design alternatives and for understanding the costs and benefits of applying the pattern. The consequences of a pattern include its impact on a system's flexibility, extensibility, or portability.        

#### Classification:
Design Patterns are divided into 3 categories:
1) Creational Patterns (It provide object creation mechanisms that increase flexibility and reuse of existing code)
2) Structural Patterns (Explain how to assemble objects and classes into larger structures while keeping the structures flexible and efficient)
3) Behavioral Patterns (Take care of effective communication, The Behavioral class patterns use inheritance to describe algorithms and flow of control, whereas the Behavioral object patterns describe how a group of objects cooperate to perform a task that no single object can carry out alone)



### Creational Patterns
  Abstract Factory	Creates an instance of several families of classes      
  Builder	Separates object construction from its representation           
  Factory Method	Creates an instance of several derived classes      
  Prototype	A fully initialized instance to be copied or cloned     
  Singleton	A class of which only a single instance can exist       

### Structural Patterns         
  Adapter	Match interfaces of different classes                       
  Bridge	Separates an object’s interface from its implementation         
  Composite	A tree structure of simple and composite objects        
  Decorator	Add responsibilities to objects dynamically         
  Facade	A single class that represents an entire subsystem          
  Flyweight	A fine-grained instance used for efficient sharing          
  Proxy	An object representing another object           

### Behavioral Patterns                                                                         
  Chain of Resp.	A way of passing a request between a chain of objects                   
  Command	Encapsulate a command request as an object                  
  Interpreter	A way to include language elements in a program                     
  Iterator	Sequentially access the elements of a collection                    
  Mediator	Defines simplified communication between classes                
  Memento	Capture and restore an object's internal state              
  Observer	A way of notifying change to a number of classes                        
  State	Alter an object's behavior when its state changes                       
  Strategy	Encapsulates an algorithm inside a class                                    
  Template Method	Defer the exact steps of an algorithm to a subclass                     
  Visitor	Defines a new operation to a class without change           











