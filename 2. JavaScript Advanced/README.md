# JustJavascript

Need to Add some more topics
[@Check more topics here:](https://github.com/zero-to-mastery)

### Javascript Algorithms and data Structures (https://github.com/zero-to-mastery/javascript-algorithms)

# JustJavascript

[JavaScript] important concepts

## [Just JavaScript] 02. Intermediate

## IIFE

Immediately Invoked Function Expression

ES5 -> JavaScript IIFE (Immediately Invoked Function Expression)  
<img src="https://raw.githubusercontent.com/kambleaa007/Javascript/master/1.%20JavaScript%20Basics/pics/1.png" width="400" height="400">

ES6 -> JavaScript IIFE (arrow functions)  
<img src="https://raw.githubusercontent.com/kambleaa007/Javascript/master/1.%20JavaScript%20Basics/pics/2.png" width="400" height="400">

## MVC

Model-view-controller is a design-framework (\*not a programming language) that allows us to separate behavior into a practical real-world structure. Almost 85% of web-based applications today have this underlying pattern in one way or the other.

ES5 -> Model-view-controller design-pattern  
<img src="https://raw.githubusercontent.com/kambleaa007/Javascript/master/1.%20JavaScript%20Basics/pics/3.png" width="600" height="200">

ES6 -> Model-view-controller design-pattern (arrow functions)  
<img src="https://raw.githubusercontent.com/kambleaa007/Javascript/master/1.%20JavaScript%20Basics/pics/4.png" width="600" height="200">

## async / await

Stop and wait until something is resolved.
It provides a way to maintain asynchronous processing in a more synchronous fashion.
For instance, you need to check if a user’s password is correct (compare to what exists in the server) before allowing the user to enter the system.
Or maybe you’ve performed a REST API request and you want the data to fully load before pushing it to the view.

1. Synchronous capabilities
2. Controls the behavior
3. Reduces “callback hell”

ES5 -> Async and Await promises  
<img src="https://raw.githubusercontent.com/kambleaa007/Javascript/master/1.%20JavaScript%20Basics/pics/5.png" width="600" height="200">

ES6 -> Async and Await promises (arrow functions)  
<img src="https://raw.githubusercontent.com/kambleaa007/Javascript/master/1.%20JavaScript%20Basics/pics/6.png" width="600" height="200">

## Callback

is a function that executes after another function has executed. It is also referred to as a call-after
A function that waits for another function to execute or return a value (array or object) is referred to as a callback.
A callback is a way to make asynchronous operations more synchronous (sequential order).

callback hell
have a recursive structure of callbacks (callbacks within callbacks within callbacks and so forth). This is not practical.

ES5 -> JavaScript Callback  
<img src="https://raw.githubusercontent.com/kambleaa007/Javascript/master/1.%20JavaScript%20Basics/pics/7.png" width="500" height="380">

ES6 -> JavaScript Callback (arrow functions)  
<img src="https://raw.githubusercontent.com/kambleaa007/Javascript/master/1.%20JavaScript%20Basics/pics/8.png" width="500" height="380">

In JavaScript, a closure is a function to which the variables of the surrounding context are bound by reference.
In JavaScript, closures are created every time a function is created, at function creation time.

## Lexical scoping

Nested functions have access to variables declared in their outer scope.

## Closure

This Outputs Alert with 'Mozilla',
Inner fun() remebers environment @time closure created, even after Outer fun() returned ->

        function makeFunc() {
        var name = 'Mozilla';
        function displayName() {
                alert(name);
        }
        return displayName;
        }

        var myFunc = makeFunc(); // or makeFunc()();
        myFunc();

In some programming languages, the local variables within a function exist for just the duration of that function's execution.
Once makeFunc() finishes executing, you might expect that the name variable would no longer be accessible.However, because the code still works as expected, this is obviously not the case in JavaScript.

Explanation: The reason is that functions in JavaScript form closures. A closure is the combination of a function and the lexical environment within which that function was declared. This environment consists of any local variables that were in-scope at the time the closure was created. In this case, myFunc is a reference to the instance of the function displayName created when makeFunc is run. The instance of displayName maintains a reference to its lexical environment, within which the variable name exists. For this reason, when myFunc is invoked, the variable name remains available for use, and "Mozilla" is passed to alert.

## Closures

Whenever you create a function within another function, you have created a closure.
:point_right: The inner function is the closure.
The closure gonna extend behavior of outer fun()
The closure has access to outer fun() variables
This closure is usually returned so you can :point_right: use the outer function’s variables at a later time.

        function outerFunction () {
        const outer = `I see the outer variable!`

        return function innerFunction() {
        console.log(outer)
        }
        }

        outerFunction()() // I see the outer variable!

1.  To control side effects

You wanna bake some flavour cake -> decide flavour? -> and then decide when to bake?
const makeCakeLater = prepareCake('banana') -> banana flavour
makeCakeLater() -> when u want to bake -> ready after a sec.

        function prepareCake (flavor) {
        return function () {
        setTimeout(_ => console.log(`Made a ${flavor} cake!`), 1000)
        }
        }

        const makeCakeLater = prepareCake('banana')

        // And later in your code...
        makeCakeLater()
        // Made a banana cake!

2. To create private variables

### Summary

Every function has an execution context, which comprises of an environment that gives meaning to the variables within that function and a reference to its parent’s environment. A reference to the parent’s environment makes all variables in the parent scope available for all inner functions, regardless of whether the inner function(s) are invoked outside or inside the scope in which they were created.

So, it appears as if the function “remembers” this environment (or scope) because the function literally has a reference to the environment (and the variables defined in that environment)!

### Conclusion

The way I will always remember closures is through the backpack analogy. When a function gets created and passed around or returned from another function, it carries a backpack with it. And in the backpack are all the variables that were in scope when the function was declared.

When code is run in JavaScript, the environment in which it is executed is very important, and is evaluated as 1 of the following:
Global code — The default environment where your code is executed for the first time.
Function code — Whenever the flow of execution enters a function body.

In other words, as we start the program, we start in the global execution context. Some variables are declared within the global execution context. We call these global variables. When the program calls a function, what happens? A few steps:
JavaScript creates a new execution context, a local execution context
That local execution context will have its own set of variables, these variables will be local to that execution context.
The new execution context is thrown onto the execution stack. Think of the execution stack as a mechanism to keep track of where the program is in its execution
When does the function end? When it encounters a return statement or it encounters a closing bracket }. When a function ends, the following happens:
The local execution contexts pops off the execution stack
The functions sends the return value back to the calling context. The calling context is the execution context that called this function, it could be the global execution context or another local execution context. It is up to the calling execution context to deal with the return value at that point. The returned value could be an object, an array, a function, a boolean, anything really. If the function has no return statement, undefined is returned.
The local execution context is destroyed. This is important. Destroyed. All the variables that were declared within the local execution context are erased. They are no longer available. That’s why they’re called local variables.

### in short -->

A closure is the combination of a function bundled together (enclosed) with references to its surrounding state (the lexical environment).
In other words, a closure gives you access to an outer function’s scope from an inner function. In JavaScript, closures are created every time a function is created, at function creation time.

If you ask me, i would say that closures enables us to create stateful functions.
Step 1 ->
Stateful functions
Stateful functions are functions that can “remember” data from previous executions. For example lets create a function that “remembers” and count how many times it got executed, each time that we will invoke it, it will log the number of times it got executed
Step 2 ->
Execution context
Every time we invoke a function, a new execution context is created, and each execution context has it’s own “Variable Environment” or “scope” if you will.
When the function is “done”, e.g with a return statement or there are no more lines of code to execute, the engine will mark it to be garbage collected, meaning it’s entire environment will get disposed.
Step 3 ->
Global execution context
When we start our program, the engine will create a global execution context for us, its not different from the execution context we create when we invoke a function. It also has a “Variable Environment” just like any other execution context, the difference is that the global execution context will never “die” (as long as our program is running of course), hence it’s variable environment won’t get disposed by the garbage collector.
Step 4 ->
Lexical Scope
Lexical Scope is basically a fancy way of saying “Static Scope”, meaning we know at creation time what is the scope of our function.
`WHERE you define your function, determines what variables the function have access to WHEN it gets called.`
In other words, it doesn’t matter where and how you invoke the function, its all about where did it got declared.

But how do we declare a function in one place, and invoke it in another place? Well, we can create a function within a function and return it:
It turns out, that when we return a function, we are not only returning our function definition but we also return it’s entire lexical environment.

This gives us the ability to create stateful functions with shared data across executions, it also allows us to create “private” variables that our global execution context doesn’t have access to.

### TL;DR

Execution context is an abstract concept used by the ECMAScript specification to track the runtime evaluation of code. At any point in time, there can only be one execution context that is executing code.
Every execution context has a Lexical Environment. This Lexical environments holds identifier bindings (i.e. variables and their associated values), and also has a reference to its outer environment.
The set of identifiers that each environment has access to is called “scope.” We can nest these scopes into a hierarchical chain of environments, known as the “scope chain”.
Every function has an execution context, which comprises of a Lexical Environment that gives meaning to the variables within that function and a reference to its parent’s environment. And so it appears as if the function “remembers” this environment (or scope) because the function literally has a reference to this environment. This is a closure.
A closure is created every time an enclosing outer function is called. In other words, the inner function does not need to return for a closure to be created.
The scope of a closure in JavaScript is lexical, meaning it’s defined statically by its location within the source code.
Closures have many practical use cases. One important use case is to maintain a private reference to a variable in the outer scope.

## Emulating private methods with closures

Each closure references a different version of the privateCounter variable through its own closure.

        var makeCounter = function() {
        var privateCounter = 0;
        function changeBy(val) {
            privateCounter += val;
        }
        return {
            increment: function() {
            changeBy(1);
            },

            decrement: function() {
            changeBy(-1);
            },

            value: function() {
            return privateCounter;
            }
        }
        };

        var counter1 = makeCounter();
        var counter2 = makeCounter();

Using closures in this way provides benefits that are normally associated with object-oriented programming. In particular, data hiding and encapsulation.

## Problems with loop and var

        for (var i = 0; i < 3; i++) { // all var item, points to i = 2, caz loop iterated already to end
            var item = arr[i];
        }

Avoid this problem using IIFE,

        for (var i = 0; i < 3; i++) { // all var item, points to i = 2, caz loop iterated already to end
            (function(i){
                var item = arr[i];
                })(i) // IIFE pass value and call execution immediatly
        }

If you don't want to use more closures, you can use the let keyword introduced in ES2015 :

        for (let i = 0; i < 3; i++) {
            let item = arr[i];
        }

This example uses let instead of var, so every closure binds the block-scoped variable, meaning that no additional closures are required.
There is a different instance on each iteration of the loop. This happens because let has a block-level scope instead of the global function scope that var has.
let allows you to declare variables that are limited in scope to the block, statement, or expression on which it is used. This is unlike the var keyword, which defines a variable globally, or locally to an entire function regardless of block scope.

Another alternative could be to use forEach() to iterate over the array

        var funcs = [];
        // let's create 3 functions
        for (var i = 0; i < 3; i++) {
                // and store them in funcs
                funcs[i] = function() {
                // each should log its value.
                console.log("My value: " + i);
        };
        }
        for (var j = 0; j < 3; j++) {
                // and now let's run each one to see
                funcs[j]();
        }

OUTPUT:
It outputs this:

        My value: 3
        My value: 3
        My value: 3

        Whereas I'd like it to output:

        My value: 0
        My value: 1
        My value: 2

`Classic solution: Closures`
What you want to do is bind the variable within each function to a separate, unchanging value outside of the function:
Since there is no block scope in JavaScript - only function scope - by wrapping the function creation in a new function, you ensure that the value of "i" remains as you intended.

        var funcs = [];

        function createfunc(i) {
                return function() {
                console.log("My value: " + i);
                };
        }

        for (var i = 0; i < 3; i++) {
                funcs[i] = createfunc(i);
        }

        for (var j = 0; j < 3; j++) {
                // and now let's run each one to see
                funcs[j]();
        }

## IIFE ES5 ES6

IIFE was one of the most used patterns in the ES5, as functions were the only way to declare a scoped block of code.

        (function(i){
        //use i
        })(i)

The only case, where you may want to use an IIFE in ES6, is with an immediately-invoked arrow functions, that requires more than a single expression, for example:

        (() => {
            // outer context this is used as fat arrow dont have own this
        })();

or bind this to function being to props to child compo

        functionName.bind(this)

### JavaScript Hoisting

#### Hoisting -> Hoisting is JavaScript's default behavior of moving declarations to the top.

While variables declared with var keyword are hoisted
(initialized with undefined before the code is run)
which means they are accessible in their enclosing scope even before they are declared:

        function run() {
        console.log(foo); // undefined
        var foo = "Foo";
        console.log(foo); // Foo
        }

        run();

let variables are not initialized until their definition is evaluated.
Accessing them before the initialization results in a ReferenceError.
Variable said to be in "temporal dead zone" from the start of the block until the initialization is processed.

        function checkHoisting() {
        console.log(foo); // ReferenceError
        let foo = "Foo";
        console.log(foo); // Foo
        }

        checkHoisting();

### JavaScript Use Strict

#### "Use Strict" -> "use strict"; Defines that JavaScript code should be executed in "strict mode".

## JavaScript this Keyword

#### this -> The JavaScript this keyword refers to the object it belongs to.

It has different values depending on where it is used:

In a method, this refers to the owner object.
Alone, this refers to the global object.
In a function, this refers to the global object.
In a function, in strict mode, this is undefined.
In an event, this refers to the element that received the event.
Methods like call(), and apply() can refer this to any object.

## JavaScript Scope

#### Before ES15 only Two Scopes

#### 1. Global Scope 2. Function Scope

#### 3. Now, Block Scope variables (let)Constants (const) in JavaScript.

A Block {} Scope

        1. var
        {
        var x = 2;
        }
        // x CAN be used here

        2. let
        {
        let x = 2;
        }
        // x can NOT be used here

Problems

        1. var Problem
        var x = 10;
        // Here x is 10
        {
        var x = 2;
        // Here x is 2
        }
        // Here x is 2

        2. let solution
        var x = 10;
        // Here x is 10
        {
        let x = 2;
        // Here x is 2
        }
        // Here x is 10

Using const is safer than using var, because a function expression is always constant value.

        // ES5
        var x = function(x, y) {
        return x * y;
        }

        // ES6
        const x = (x, y) => x * y;

## Methos in ES5 / ECMAScript 2009 / JavaScript 5

These were the new features released in 2009:

        "use strict"
        String.trim()
        Array.isArray()
        Array.forEach()
        Array.map()
        Array.filter()
        Array.reduce()
        Array.reduceRight()
        Array.every()
        Array.some()
        Array.indexOf()
        Array.lastIndexOf()
        JSON.parse()
        JSON.stringify()
        Date.now()
        Property Getters and Setters
        New Object Property Methods

String.trim()
removes whitespace from both sides of a string

Array.isArray()
checks whether an object is an array

Array.forEach()
calls a function (pass as argument) once for each array element
Note that the function takes 3 arguments:
The item value
The item index
The array itself

Array.map()
multiplies each array value
The map() method creates a new array by performing a function on each array element.
The map() method does not execute the function for array elements without values.
The map() method does not change the original array.

        var numbers1 = [45, 4, 9, 16, 25];
        var numbers2 = numbers1.map(myFunction);

        function myFunction(value, index, array) {
        return value * 2;
        }

Array.filter()
creates a new array from elements with a condition True (pass function returns true/false)

        var numbers = [45, 4, 9, 16, 25];
        var over18 = numbers.filter(myFunction);

        function myFunction(value, index, array) {
        return value > 18;
        }

or

        var numbers = [45, 4, 9, 16, 25];
        var over18 = numbers.filter(myFunction);

        function myFunction(value) {
        return value > 18;
        }

Array.reduce()
finds the sum of all numbers in an array (pass func takes two arguments)
The reduce() method runs a function on each array element to produce (reduce it to) a single value.
The reduce() method works from left-to-right in the array. See also reduceRight().
The reduce() method does not reduce the original array.

Note that the function takes 4 arguments:

The total (the initial value / previously returned value)
The item value
The item index
The array itself

        var numbers1 = [45, 4, 9, 16, 25];
        var sum = numbers1.reduce(myFunction);

        function myFunction(total, value, index, array) {
        return total + value;
        }

The reduce() method can accept an initial value:

        var numbers1 = [45, 4, 9, 16, 25];
        var sum = numbers1.reduce(myFunction, 100);

        function myFunction(total, value) {
        return total + value;
        }

Array.every()
checks if all values with a condition True

        var numbers = [45, 4, 9, 16, 25];
        var allOver18 = numbers.every(myFunction);

        function myFunction(value) {
        return value > 18;
        }

Array.some()
checks if some values

## ES6 / ECMAScript 2015 / JavaScript 6

New Features in ES6,

        JavaScript let
        JavaScript const
        JavaScript Arrow Functions
        JavaScript Classes
        Default parameter values
        Array.find()
        Array.findIndex()
        Exponentiation (**) (EcmaScript 2016)

## ECMAScript 2016

        Added exponential operator (\*\*).

Exponentiation Operator
The exponentiation operator (\*\*) raises the first operand to the power of the second operand.

        var x = 5;
        var z = x ** 2;          // result is 25

x \*\* y produces the same result as Math.pow(x,y):

        var x = 5;
        var z = Math.pow(x,2);   // result is 25


        Added Array.prototype.includes.

## ECMAScript 2017

        Added string padding.
        Added new Object properties.
        Added Async functions.
        Added Shared Memory.

## ECMAScript 2018

        Added rest / spread properties.
        Added Asynchronous iteration.
        Added Promise.finally().
        Additions to RegExp.

## JavaScript JSON -> parse text and stringify object

JSON is a format for storing and transporting data.
JSON is often used when data is sent from a server to a web page.

JSON stands for JavaScript Object Notation
JSON is a lightweight data interchange format
JSON is language independent
JSON is "self-describing" and easy to understand

JSON Syntax Rules :

Data is in name/value pairs
Data is separated by commas
Curly braces hold objects
Square brackets hold arrays

Converting a JSON Text or Data to a JavaScript Object
Then, use the JavaScript built-in function JSON.parse() to convert the string into a JavaScript object:

        var text = '{ "employees" : [' +
        '{ "firstName":"John" , "lastName":"Doe" },' +
        '{ "firstName":"Anna" , "lastName":"Smith" },' +
        '{ "firstName":"Peter" , "lastName":"Jones" } ]}';

        var obj = JSON.parse(text);

Stringify a JavaScript Object
When sending data to a web server, the data has to be a string.
Convert a JavaScript object into a string with JSON.stringify().

        var obj = { name: "John", age: 30, city: "New York" };
        var myJSON = JSON.stringify(obj);

## Prototype Inheritance

## Single threaded JS & Event Loop

Is Javascript Multi threaded or Single threaded”???
I said Single.
He then asked, “Then how the ASYNC calls are handled and the UI thread is responsive during the call”???
I couldn’t answer then.

Javascript is actually single threaded, each tab or window runs a single JS thread. JS engine manages a queue of events to which events are enqued and dequed, when an async call is sent through ajax and its response is received, an event is pushed into that event queue.

JS thread keeps on checking that queue when thread is idle and there is nothing to execute, if there is something in the queue, it pops it out and execute.

The single threaded behavior can be understood by the example that there are two events in the event queue for ajax response received and one for a mouse over,
but we are executing an infinite loop in the current JS thread,
those callbacks will not get a chance to run no matter their time has come and will always be executed when the thread is idle.

## Promises

A Promise is an object representing the eventual completion or failure of an asynchronous operation.

        fetch()
           .then(res).catch(err)

or

        var p1 = fetch("http://1");
        var p2 = fetch("http://11");
        var p3 = fetch("http://111");

        Promise.all([p1, p2, p3]).then(function(students) {
        console.log("All the students are here: " + students);
        });


## Functional Programming

## Higher Order Functions


## Composition


## Callback Functions

## Filter

## Map

## Reject

## Find




To Be Continued...
