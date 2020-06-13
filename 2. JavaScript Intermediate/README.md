# JustJavascript

[JavaScript] important concepts

## [Just JavaScript] 01. Intermediate

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

To Be Continued...
