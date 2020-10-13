/*
The singleton pattern is one of the simplest design patterns. 
Sometimes we need to have only one instance of our class 
for example a single DB connection shared by multiple objects as creating a separate DB connection for every object may be costly. 
Similarly, there can be a single configuration manager or error manager in an application 
that handles all problems instead of creating multiple managers.

Definition:
The singleton pattern is a design pattern that restricts the instantiation of a class to one object.
Let’s see various design options for implementing such a class. 
If you have a good handle on static class variables and access modifiers this should not be a difficult task.
*/


// Method 1: Classic Implementation
// Classical Java implementation of singleton  
// design pattern 
class Singleton 
{ 
    private static Singleton obj; 
  
    // private constructor to force use of 
    // getInstance() to create Singleton object 
    private Singleton() {} 
  
    public static Singleton getInstance() 
    { 
        if (obj==null) 
            obj = new Singleton(); 
        return obj; 
    } 
} 

/*
Here we have declared getInstance() static so that we can call it without instantiating the class. 
The first time getInstance() is called it creates a new singleton object and after that it just returns the same object. 
Note that Singleton obj is not created until we need it and call getInstance() method. This is called lazy instantiation.

The main problem with above method is that it is not thread safe. Consider the following execution sequence.
*/

// Method 2: make getInstance() synchronized
// Thread Synchronized Java implementation of 
// singleton design pattern 
class Singleton 
{ 
	private static Singleton obj; 

	private Singleton() {} 

	// Only one thread can execute this at a time 
	public static synchronized Singleton getInstance() 
	{ 
		if (obj==null) 
			obj = new Singleton(); 
		return obj; 
	} 
} 


// Method 3: Eager Instantiation
// Static initializer based Java implementation of 
// singleton design pattern 
class Singleton 
{ 
	private static Singleton obj = new Singleton(); 

	private Singleton() {} 

	public static Singleton getInstance() 
	{ 
		return obj; 
	} 
} 


/* 

FAQs:

Real World Example: LOGGER
Question: Why can’t we use a static class instead of singleton?
Answer:

One of the key advantages of singleton over static class is that it can implement interfaces and extend classes while the static class cannot (it can extend classes, but it does not inherit their instance members). If we consider a static class it can only be a nested static class as top level class cannot be a static class. Static means that it belongs to a class it is in and not to any instance. So it cannot be a top level class.
Another difference is that static class will have all its member as static only unlike Singleton.
Another advantage of Singleton is that it can be lazily loaded whereas static will be initialized whenever it is first loaded.
Singleton object stores in Heap but, static object stores in stack.
We can clone the object of Singleton but, we can not clone the static class object.
Singleton can use the Object Oriented feature of polymorphism but static class cannot.
Question: Can the singleton class be subclassed?
Answer: Frankly speaking singleton is just a design pattern and it can be subclassed. However it is worth to understand the logic or requirement behind subclassing a singleton class as the child class might not inherit the singleton pattern objective by extending the Singleton class. However the subclassing can be prevented by using the final keyword in the class declaration.

Question: Can there be multiple instance of singleton using cloning?
Answer: That was a good catch! What do we do now? To prevent the another instance to be created of the singleton instance we can throw exception from inside the clone() method.

Question: What is the impact if we are creating another instance of singleton using serialization and deserialization?
Answer: When we serialize a class and deserialize it then it creates another instance of the singleton class. Basically as many times as you deserialize the singleton instance it will create multiple instance. Well in this case the best way is to make the singleton as enum. In that way the underlying Java implementation takes care of all the details. If this is not possible then we will need to override the readobject() method to return the same singleton instance.

Question: Which other pattern works with Singleton?
Answer:There are several other pattern like Factory method, builder and prototype pattern which uses Singleton pattern during the implementation.

Question: Which classes in JDK uses singleton pattern?
Answer: java.lang.Runtime : In every Java application there is only one Runtime instance that allows the application to interface with the environment it is running. The getRuntime is equivalent to the getInstance() method of the singleton class.



*/