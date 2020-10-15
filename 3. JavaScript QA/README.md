# JustJavascript

[JavaScript] important concepts

## [Just JavaScript] 04. JavaScript QA

### Difference Between Class & Prototypal Inheritance

JavaScript’s object system is based on prototypes, not classes.

Class Inheritance: A class is like a blueprint — a description of the object to be created.
Prototypal Inheritance: A prototype is a working object instance. Objects inherit directly from other objects.

        class Foo {}
        typeof Foo // 'function'

Class inheritance creates parent/child object taxonomies as a side-effect.

Problems in OO Design :

The tight coupling problem (class inheritance is the tightest coupling available in oo design), which leads to the next one…
The fragile base class problem
Inflexible hierarchy problem (eventually, all evolving hierarchies are wrong for new uses)
The duplication by necessity problem (due to inflexible hierarchies, new use cases are often shoe-horned in by duplicating, rather than adapting existing code)
The Gorilla/banana problem (What you wanted was a banana, but what you got was a gorilla holding the banana, and the entire jungle)

“Favor object composition over class inheritance.”
~ The Gang of Four

## Q&A

What's a typical use case for anonymous functions? -> used in IIFEs

Can you describe the main difference between a .forEach loop and a .map() loop?
The main difference between .forEach and .map() is that .map() returns a new array. If you need the result, but do not wish to mutate the original array, .map() is the clear choice. If you simply need to iterate over an array, forEach is a fine choice.

Can you give an example of one of the ways that working with this has changed in ES6?
ES6 allows you to use arrow functions which uses the enclosing lexical scope. This is usually convenient, but does prevent the caller from controlling context via .call or .apply—the consequences being that a library such as jQuery will not properly bind this in your event handler functions. Thus, it's important to keep this in mind when refactoring large legacy applications.

Explain how prototypal inheritance works?
This is an extremely common JavaScript interview question. All JavaScript objects have a **_proto_** property, that is a reference to another object, which is called the object's "prototype". When a property is accessed on an object and if the property is not found on that object, the JavaScript engine looks at the object's **_proto_**, and the **_proto_**'s **_proto_** and so on, until it finds the property defined on one of the **_proto_**s or until it reaches the end of the prototype chain. This behavior simulates classical inheritance, but it is really more of delegation than inheritance.

Explain why the following doesn't work as an IIFE: function foo(){ }();. What needs to be changed to properly make it an IIFE?
adding more parentheses: (function foo(){ })() and (function foo(){ }()).
Statements that begin with function are considered to be function declarations; by wrapping this function within (), it becomes a function expression which can then be executed with the subsequent ().

What's the difference between a variable that is: null, undefined or undeclared? How would you go about checking for any of these states?
Undeclared variables are created when you assign a value to an identifier that is not previously created using var, let or const. Undeclared variables will be defined globally, outside of the current scope. In strict mode, a ReferenceError will be thrown when you try to assign to an undeclared variable. Undeclared variables are bad just like how global variables are bad. Avoid them at all cost! To check for them, wrap its usage in a try/catch block.

        function foo() {
        x = 1; // Throws a ReferenceError in strict mode
        }

        foo();
        console.log(x); // 1

A variable that is undefined is a variable that has been declared, but not assigned a value. It is of type undefined. If a function does not return any value as the result of executing it is assigned to a variable, the variable also has the value of undefined. To check for it, compare using the strict equality (===) operator or typeof which will give the 'undefined' string. Note that you should not be using the abstract equality operator to check, as it will also return true if the value is null.

        var foo;
        console.log(foo); // undefined
        console.log(foo === undefined); // true
        console.log(typeof foo === 'undefined'); // true

        console.log(foo == null); // true. Wrong, don't use this to check!

        function bar() {}
        var baz = bar();
        console.log(baz); // undefined

A variable that is null will have been explicitly assigned to the null value. It represents no value and is different from undefined in the sense that it has been explicitly assigned. To check for null, simply compare using the strict equality operator. Note that like the above, you should not be using the abstract equality operator (==) to check, as it will also return true if the value is undefined.

        var foo = null;
        console.log(foo === null); // true
        console.log(typeof foo === 'object'); // true

        console.log(foo == undefined); // true. Wrong, don't use this to check!

What is a closure, and how/why would you use one?
A closure is the combination of a function and the lexical environment within which that function was declared. The word "lexical" refers to the fact that lexical scoping uses the location where a variable is declared within the source code to determine where that variable is available. Closures are functions that have access to the outer (enclosing) function's variables—scope chain even after the outer function has returned.

Why would you use one?
Data privacy / emulating private methods with closures. Commonly used in the module pattern.

What's a typical use case for anonymous functions?
They can be used in IIFEs to encapsulate some code within a local scope so that variables declared in it do not leak to the global scope.

        (function () {
        // Some code here.
        })();

Difference between: function Person(){}, var person = Person(), and var person = new Person()?
This question is pretty vague. My best guess at its intention is that it is asking about constructors in JavaScript. Technically speaking, function Person(){} is just a normal function declaration. The convention is to use PascalCase for functions that are intended to be used as constructors.

var person = Person() invokes the Person as a function, and not as a constructor. Invoking as such is a common mistake if the function is intended to be used as a constructor. Typically, the constructor does not return anything, hence invoking the constructor like a normal function will return undefined and that gets assigned to the variable intended as the instance.

var person = new Person() creates an instance of the Person object using the new operator, which inherits from Person.prototype. An alternative would be to use Object.create, such as: Object.create(Person.prototype).

        function Person(name) {
        this.name = name;
        }

        var person = Person('John');
        console.log(person); // undefined
        console.log(person.name); // Uncaught TypeError: Cannot read property 'name' of undefined

        var person = new Person('John');
        console.log(person); // Person { name: "John" }
        console.log(person.name); // "john"

What's the difference between .call and .apply?
Both .call and .apply are used to invoke functions and the first parameter will be used as the value of this within the function. However, .call takes in comma-separated arguments as the next arguments while .apply takes in an array of arguments as the next argument. An easy way to remember this is C for call and comma-separated and A for apply and an array of arguments.

        function add(a, b) {
        return a + b;
        }

        console.log(add.call(null, 1, 2)); // 3
        console.log(add.apply(null, [1, 2])); // 3

Explain Function.prototype.bind.
The bind() method creates a new function that, when called, has its this keyword set to the provided value, with a given sequence of arguments preceding any provided when the new function is called.

In my experience, it is most useful for binding the value of this in methods of classes that you want to pass into other functions. This is frequently done in React components.

why we need to bind event handlers in Class Components in React?
The value of this inside a function depends upon how that function is invoked.
This depends how the function is called, not how/where it is created.

Default Binding

        function display(){
        console.log(this); // 'this' will point to the global object
        }
        display();

The value of this inside the display() method in this case is the window — or the global — object in non-strict mode. In strict mode, the this value is undefined.

The bodies of class declarations and class expressions are executed in strict mode,

        class Foo {
        constructor(name){
        this.name = name
        }

        display(){
        console.log(this.name);
        }
        }

        var foo = new Foo('Saurabh');
        foo.display(); // Saurabh

        // The assignment operation below simulates loss of context
        // similar to passing the handler as a callback in the actual
        // React Component
        var display = foo.display;
        display(); // TypeError: this is undefined

So, to prevent the error, we need to bind the this value like this:

        class Foo {
        constructor(name){
        this.name = name
        this.display = this.display.bind(this);
        }

        display(){
        console.log(this.name);
        }
        }

        var foo = new Foo('Saurabh');
        foo.display(); // Saurabh

        var display = foo.display;
        display(); // Saurabh

We don’t need to do this in the constructor, and we can do this somewhere else as well.

        class Foo extends React.Component{
        constructor( props ){ // No this Binding }
        handleClick(event){
        console.log(this); // 'this' is undefined
        }
        render(){ return (
        <button type="button" onClick={this.handleClick}>
        )}

Why don’t we need to bind ‘this’ for Arrow functions?
The reason is that in the case of arrow functions, this is bound lexically. This means that it uses the context of the enclosing function — or global — scope as its this value.
Arrow functions are exempt from this behavior because they use lexical this binding which automatically binds them to the scope they are defined in.

1.  Public Class Fields Syntax(Experimental)
    In the case of the public class fields syntax example, the arrow function is enclosed inside the Foo class — or constructor function — so the context is the component instance, which is what we want.


        class Foo extends React.Component{
        handleClick = () => {}
        render(){
        <button type="button" onClick={this.handleClick}>
        }

2.  Arrow function in the callback
    In the case of the arrow function as callback example, the arrow function is enclosed inside the render() method, which is invoked by React in the context of the component instance. This is why the arrow function will also capture this same context, and the this value inside it will properly point to the component instance.


        class Foo extends React.Component{
        handleClick(event){}
        render(){
        <button type="button" onClick={(e) => this.handleClick(e)}>
        }

But, Use 1. instead of 2. as,
Arrow function should not be used in the component render method. Render is called repeatedly, thus arrow function create a new function often and unnecessary.
Remember: Bind creates a new function!

Explain Ajax in as much detail as possible?
Ajax (asynchronous JavaScript and XML) is a set of web development techniques using many web technologies on the client side to create asynchronous web applications. With Ajax, web applications can send data to and retrieve from a server asynchronously (in the background) without interfering with the display and behavior of the existing page. By decoupling the data interchange layer from the presentation layer, Ajax allows for web pages, and by extension web applications, to change content dynamically without the need to reload the entire page. In practice, modern implementations commonly substitute use JSON instead of XML, due to the advantages of JSON being native to JavaScript.

The XMLHttpRequest API is frequently used for the asynchronous communication or these days, the fetch API.

What are the advantages and disadvantages of using Ajax?

Advantages
Better interactivity. New content from the server can be changed dynamically without the need to reload the entire page.
Reduce connections to the server since scripts and stylesheets only have to be requested once.
State can be maintained on a page. JavaScript variables and DOM state will persist because the main container page was not reloaded.
Basically most of the advantages of an SPA.

Disadvantages
Dynamic webpages are harder to bookmark.
Does not work if JavaScript has been disabled in the browser.
Some webcrawlers do not execute JavaScript and would not see content that has been loaded by JavaScript.
Webpages using Ajax to fetch data will likely have to combine the fetched remote data with client-side templates to update the DOM. For this to happen, JavaScript will have to be parsed and executed on the browser, and low-end mobile devices might struggle with this.
Basically most of the disadvantages of an SPA.

Explain "hoisting"?
Hoisting is a term used to explain the behavior of variable declarations in your code. Variables declared or initialized with the var keyword will have their declaration "moved" up to the top of their module/function-level scope, which we refer to as hoisting. However, only the declaration is hoisted, the assignment (if there is one), will stay where it is.

Describe event bubbling?
When an event triggers on a DOM element, it will attempt to handle the event if there is a listener attached, then the event is bubbled up to its parent and the same thing happens. This bubbling occurs up the element's ancestors all the way to the document. Event bubbling is the mechanism behind event delegation.

What is the difference between == and ===?

== is the abstract equality operator while === is the strict equality operator. The == operator will compare for equality after doing any necessary type conversions. The === operator will not do type conversion, so if two values are not the same type === will simply return false. When using ==, funky things can happen, such as:

1 == '1'; // true
1 == [1]; // true
1 == true; // true
0 == ''; // true
0 == '0'; // true
0 == false; // true
My advice is never to use the == operator, except for convenience when comparing against null or undefined, where a == null will return true if a is null or undefined.

var a = null;
console.log(a == null); // true
console.log(a == undefined); // true

Make this work:

> duplicate([1, 2, 3, 4, 5]); // [1,2,3,4,5,1,2,3,4,5]?

        function duplicate(arr) {
        return arr.concat(arr);
        }

        duplicate([1, 2, 3, 4, 5]); // [1,2,3,4,5,1,2,3,4,5]

Or with ES6:

        const duplicate = (arr) => [...arr, ...arr];

        duplicate([1, 2, 3, 4, 5]); // [1,2,3,4,5,1,2,3,4,5]

What is "use strict";?

'use strict' is a statement used to enable strict mode to entire scripts or individual functions. Strict mode is a way to opt into a restricted variant of JavaScript.

Advantages:

Makes it impossible to accidentally create global variables.
Makes assignments which would otherwise silently fail to throw an exception.
Makes attempts to delete undeletable properties throw (where before the attempt would simply have no effect).
Requires that function parameter names be unique.
this is undefined in the global context.
It catches some common coding bloopers, throwing exceptions.
It disables features that are confusing or poorly thought out.
Disadvantages:

Many missing features that some developers might be used to.
No more access to function.caller and function.arguments.
Concatenation of scripts written in different strict modes might cause issues.
Overall, I think the benefits outweigh the disadvantages, and I never had to rely on the features that strict mode blocks. I would recommend using strict mode.

Create a for loop that iterates up to 100 while outputting "fizz" at multiples of 3, "buzz" at multiples of 5 and "fizzbuzz" at multiples of 3 and 5?

        for (var i=1; i <= 20; i++)
        {
        if (i % 15 == 0)
                console.log("FizzBuzz");
        else if (i % 3 == 0)
                console.log("Fizz");
        else if (i % 5 == 0)
                console.log("Buzz");
        else
                console.log(i);
        }

What is the extent of your experience with Promises and/or their polyfills?
Possess working knowledge of it. A promise is an object that may produce a single value sometime in the future: either a resolved value or a reason that it's not resolved (e.g., a network error occurred). A promise may be in one of 3 possible states: fulfilled, rejected, or pending. Promise users can attach callbacks to handle the fulfilled value or the reason for rejection.

What are the pros and cons of using Promises instead of callbacks?

Pros

Avoid callback hell which can be unreadable.
Makes it easy to write sequential asynchronous code that is readable with .then().
Makes it easy to write parallel asynchronous code with Promise.all().
With promises, these scenarios which are present in callbacks-only coding, will not happen:
Call the callback too early
Call the callback too late (or never)
Call the callback too few or too many times
Fail to pass along any necessary environment/parameters
Swallow any errors/exceptions that may happen

Cons

Slightly more complex code (debatable).
In older browsers where ES2015 is not supported, you need to load a polyfill in order to use it.

What tools and techniques do you use for debugging JavaScript code?

React and Redux
React Devtools
Redux Devtools
Vue
Vue Devtools
JavaScript
Chrome Devtools
debugger statement
Good old console.log debugging

What language constructions do you use for iterating over object properties and array items?

For objects:

for-in loops - for (var property in obj) { console.log(property); }. However, this will also iterate through its inherited properties, and you will add an obj.hasOwnProperty(property) check before using it.

        var a = {"1":"a","2":"b","3":"c"};
        for(var i in a){console.log(i)} // Output 1 2 3

Object.keys() - Object.keys(obj).forEach(function (property) { ... }). Object.keys() is a static method that will lists all enumerable properties of the object that you pass it.

        Object.keys(a); // Output (3) ["1", "2", "3"]

Object.getOwnPropertyNames() - Object.getOwnPropertyNames(obj).forEach(function (property) { ... }). Object.getOwnPropertyNames() is a static method that will lists all enumerable and non-enumerable properties of the object that you pass it.

For arrays:

for loops - for (var i = 0; i < arr.length; i++). The common pitfall here is that var is in the function scope and not the block scope and most of the time you would want block scoped iterator variable. ES2015 introduces let which has block scope and it is recommended to use that instead. So this becomes: for (let i = 0; i < arr.length; i++).
forEach - arr.forEach(function (el, index) { ... }). This construct can be more convenient at times because you do not have to use the index if all you need is the array elements. There are also the every and some methods which will allow you to terminate the iteration early.

for-of loops - for (let elem of arr) { ... }. ES6 introduces a new loop, the for-of loop, that allows you to loop over objects that conform to the iterable protocol such as String, Array, Map, Set, etc. It combines the advantages of the for loop and the forEach() method. The advantage of the for loop is that you can break from it, and the advantage of forEach() is that it is more concise than the for loop because you don't need a counter variable. With the for-of loop, you get both the ability to break from a loop and a more concise syntax.

Most of the time, I would prefer the .forEach method, but it really depends on what you are trying to do. Before ES6, we used for loops when we needed to prematurely terminate the loop using break. But now with ES6, we can do that with for-of loops. I would use for loops when I need even more flexibility, such as incrementing the iterator more than once per loop.

Also, when using the for-of loop, if you need to access both the index and value of each array element, you can do so with the ES6 Array entries() method and destructuring:

        const arr = ['a', 'b', 'c'];

        for (let [index, elem] of arr.entries()) {
        console.log(index, ': ', elem);
        }

Explain the difference between mutable and immutable objects?
Immutability is a core principle in functional programming, and has lots to offer to object-oriented programs as well. A mutable object is an object whose state can be modified after it is created. An immutable object is an object whose state cannot be modified after it is created.

What is an example of an immutable object in JavaScript?
In JavaScript, some built-in types (numbers, strings) are immutable, but custom objects are generally mutable.
Some built-in immutable JavaScript objects are Math, Date.

What are the pros and cons of immutability?

Pros

Easier change detection - Object equality can be determined in a performant and easy manner through referential equality. This is useful for comparing object differences in React and Redux.
Programs with immutable objects are less complicated to think about, since you don't need to worry about how an object may evolve over time.
Defensive copies are no longer necessary when immutable objects are returning from or passed to functions, since there is no possibility an immutable object will be modified by it.
Easy sharing via references - One copy of an object is just as good as another, so you can cache objects or reuse the same object multiple times.
Thread-safe - Immutable objects can be safely used between threads in a multi-threaded environment since there is no risk of them being modified in other concurrently running threads.
Using libraries like ImmmutableJS, objects are modified using structural sharing and less memory is needed for having multiple objects with similar structures.

Cons

Naive implementations of immutable data structures and its operations can result in extremely poor performance because new objects are created each time. It is recommended to use libraries for efficient immutable data structures and operations that leverage on structural sharing.
Allocation (and deallocation) of many small objects rather than modifying existing ones can cause a performance impact. The complexity of either the allocator or the garbage collector usually depends on the number of objects on the heap.
Cyclic data structures such as graphs are difficult to build. If you have two objects which can't be modified after initialization, how can you get them to point to each other?

How can you achieve immutability in your own code?

One way to achieve immutability is to use libraries like immutable.js, mori or immer.

The alternative is to use const declarations combined with the techniques mentioned above for creation. For "mutating" objects, use the spread operator, Object.assign, Array.concat(), etc., to create new objects instead of mutate the original object.

Examples:

        // Array Example
        const arr = [1, 2, 3];
        const newArr = [...arr, 4]; // [1, 2, 3, 4]

        // Object Example
        const human = Object.freeze({race: 'human'});
        const john = {...human, name: 'John'}; // {race: "human", name: "John"}
        const alienJohn = {...john, race: 'alien'}; // {race: "alien", name: "John"}

Explain the difference between synchronous and asynchronous functions?

Synchronous functions are blocking while asynchronous functions are not. In synchronous functions, statements complete before the next statement is run. In this case, the program is evaluated exactly in order of the statements and execution of the program is paused if one of the statements take a very long time.

Asynchronous functions usually accept a callback as a parameter and execution continue on the next line immediately after the asynchronous function is invoked. The callback is only invoked when the asynchronous operation is complete and the call stack is empty. Heavy duty operations such as loading data from a web server or querying a database should be done asynchronously so that the main thread can continue executing other operations instead of blocking until that long operation to complete (in the case of browsers, the UI will freeze).

What is event loop? What is the difference between call stack and task queue?
The event loop is a single-threaded loop that monitors the call stack and checks if there is any work to be done in the task queue. If the call stack is empty and there are callback functions in the task queue, a function is dequeued and pushed onto the call stack to be executed.

Explain the differences on the usage of foo between function foo() {} and var foo = function() {}?

The former is a function declaration while the latter is a function expression. The key difference is that function declarations have its body hoisted but the bodies of function expressions are not (they have the same hoisting behavior as variables). For more explanation on hoisting, refer to the question above on hoisting. If you try to invoke a function expression before it is defined, you will get an Uncaught TypeError: XXX is not a function error.

Function Declaration

        foo(); // 'FOOOOO'
        function foo() {
        console.log('FOOOOO');
        }

Function Expression

        foo(); // Uncaught TypeError: foo is not a function
        var foo = function () {
        console.log('FOOOOO');
        };

What are the differences between variables created using let, var or const?

Variables declared using the var keyword are scoped to the function in which they are created, or if created outside of any function, to the global object. let and const are block scoped, meaning they are only accessible within the nearest set of curly braces (function, if-else block, or for-loop).

        function foo() {
        // All variables are accessible within functions.
        var bar = 'bar';
        let baz = 'baz';
        const qux = 'qux';

        console.log(bar); // bar
        console.log(baz); // baz
        console.log(qux); // qux
        }

        console.log(bar); // ReferenceError: bar is not defined
        console.log(baz); // ReferenceError: baz is not defined
        console.log(qux); // ReferenceError: qux is not defined
        if (true) {
        var bar = 'bar';
        let baz = 'baz';
        const qux = 'qux';
        }

        // var declared variables are accessible anywhere in the function scope.
        console.log(bar); // bar
        // let and const defined variables are not accessible outside of the block they were defined in.
        console.log(baz); // ReferenceError: baz is not defined
        console.log(qux); // ReferenceError: qux is not defined

var allows variables to be hoisted, meaning they can be referenced in code before they are declared. let and const will not allow this, instead throwing an error.

        console.log(foo); // undefined

        var foo = 'foo';

        console.log(baz); // ReferenceError: can't access lexical declaration 'baz' before initialization

        let baz = 'baz';

        console.log(bar); // ReferenceError: can't access lexical declaration 'bar' before initialization

        const bar = 'bar';

Redeclaring a variable with var will not throw an error, but let and const will.

        var foo = 'foo';
        var foo = 'bar';
        console.log(foo); // "bar"

        let baz = 'baz';
        let baz = 'qux'; // Uncaught SyntaxError: Identifier 'baz' has already been declared

let and const differ in that let allows reassigning the variable's value while const does not.

        // This is fine.
        let foo = 'foo';
        foo = 'bar';

        // This causes an exception.
        const baz = 'baz';
        baz = 'qux';

Can you offer a use case for the new arrow => function syntax? How does this new syntax differ from other functions?

One obvious benefit of arrow functions is to simplify the syntax needed to create functions, without a need for the function keyword. The this within arrow functions is also bound to the enclosing scope which is different compared to regular functions where the this is determined by the object calling it. Lexically-scoped this is useful when invoking callbacks especially in React components.

What is the definition of a higher-order function?

A higher-order function is any function that takes one or more functions as arguments, which it uses to operate on some data, and/or returns a function as a result. Higher-order functions are meant to abstract some operation that is performed repeatedly. The classic example of this is map, which takes an array and a function as arguments. map then uses this function to transform each item in the array, returning a new array with the transformed data. Other popular examples in JavaScript are forEach, filter, and reduce. A higher-order function doesn't just need to be manipulating arrays as there are many use cases for returning a function from another function. Function.prototype.bind is one such example in JavaScript.

Map

Let say we have an array of names which we need to transform each string to uppercase.

        const names = ['irish', 'daisy', 'anna'];
        The imperative way will be as such:

        const transformNamesToUppercase = function (names) {
        const results = [];
        for (let i = 0; i < names.length; i++) {
        results.push(names[i].toUpperCase());
        }
        return results;
        };
        transformNamesToUppercase(names); // ['IRISH', 'DAISY', 'ANNA']
        Use .map(transformerFn) makes the code shorter and more declarative.

        const transformNamesToUppercase = function (names) {
        return names.map((name) => name.toUpperCase());
        };
        transformNamesToUppercase(names); // ['IRISH', 'DAISY', 'ANNA']

Can you give an example for destructuring an object or an array?

Destructuring is an expression available in ES6 which enables a succinct and convenient way to extract values of Objects or Arrays and place them into distinct variables.

Array destructuring

        // Variable assignment.
        const foo = ['one', 'two', 'three'];

        const [one, two, three] = foo;
        console.log(one); // "one"
        console.log(two); // "two"
        console.log(three); // "three"
        // Swapping variables
        let a = 1;
        let b = 3;

        [a, b] = [b, a];
        console.log(a); // 3
        console.log(b); // 1
        Object destructuring

        // Variable assignment.
        const o = {p: 42, q: true};
        const {p, q} = o;

        console.log(p); // 42
        console.log(q); // true

What are the benefits of using spread syntax and how is it different from rest syntax?

ES6's spread syntax is very useful when coding in a functional paradigm as we can easily create copies of arrays or objects without resorting to Object.create, slice, or a library function. This language feature is used often in Redux and RxJS projects.

        function putDookieInAnyArray(arr) {
        return [...arr, 'dookie'];
        }

        const result = putDookieInAnyArray(['I', 'really', "don't", 'like']); // ["I", "really", "don't", "like", "dookie"]

        const person = {
        name: 'Todd',
        age: 29,
        };

        const copyOfTodd = {...person};

ES6's rest syntax offers a shorthand for including an arbitrary number of arguments to be passed to a function. It is like an inverse of the spread syntax, taking data and stuffing it into an array rather than unpacking an array of data, and it works in function arguments, as well as in array and object destructuring assignments.

        function addFiveToABunchOfNumbers(...numbers) {
        return numbers.map((x) => x + 5);
        }

        const result = addFiveToABunchOfNumbers(4, 5, 6, 7, 8, 9, 10); // [9, 10, 11, 12, 13, 14, 15]

        const [a, b, ...rest] = [1, 2, 3, 4]; // a: 1, b: 2, rest: [3, 4]

        const {e, f, ...others} = {
        e: 1,
        f: 2,
        g: 3,
        h: 4,
        }; // e: 1, f: 2, others: { g: 3, h: 4 }
