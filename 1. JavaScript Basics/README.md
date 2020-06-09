# JustJavascript

[JavaScript] Basics important concepts

## [Just JavaScript] 01. Basics

JavaScript is a scripting language which is used for making your website dynamic.

### Values in JavaScript :

Everything a computer’s memory hold is Data and representing Data in JavaScript is called Value. Values need to be distinguished based on their role. So, JS divides its value to 6 different type.

        Number -> NaN, Infinity, -Infinity are also of Number type
        String
        Boolean
        Undefined -> denotes the absence of a meaningful value (typeof(null) is object but typeof(undefined) is undefined)
        Function -> Functions are the only thing that produces a scope
        Object -> value that allow us to group different types of value (object also, functions also)

### Scope

Manages variables accessibility

1.  Block scope -> { } -> defines a scope for variables declared using let and const

        {
        // block scope
        const message1 = 'Hello';
        let message2 = 'Hello';
        console.log(message1); // 'Hello'
        console.log(message2); // 'Hello'
        }
        console.log(message1); // throws ReferenceError
        console.log(message2); // throws ReferenceError

> var is NOT Block Scoped

        if (true) {
        // "if" block scope
        var count = 0;
        console.log(count); // 0
        }
        console.log(count); // 0

> A code block does not create a scope for var variables, but a function body does.

2.  Function scope -> fun(){} -> defines a scope for variables declared using var, let and const.

        function run() {
        // "run" function scope
        var message = 'Run, Forrest, Run!';
        console.log(message); // 'Run, Forrest, Run!'
        }

        run();
        console.log(message); // throws ReferenceError


        function run() {
        // "run" function scope
        const two = 2;
        let count = 0;
        function run2() {}

        console.log(two);   // 2
        console.log(count); // 0
        console.log(run2);  // function
        }

        run();
        console.log(two);   // throws ReferenceError
        console.log(count); // throws ReferenceError
        console.log(run2);  // throws ReferenceError

3.  Module scope -> ES2015 module also creates a scope for variables, functions, classes.

        // "circle" module scope
        const pi = 3.14159; // NOT exported

        import './circle';
        console.log(pi); // throws ReferenceError

The variable pi is not accessible outside of circle module (unless explicitly exported using export).

4.  Scopes can be nested -> The inner scope can access the variables of its outer scope.

5.  Global scope -> outermost scope. It is accessible from any inner (aka local) scope.

        <script src="myScript.js"></script>

6.  Lexical scope -> the inner function scope can access variables from the outer function scope.

The lexical scope consists of outer scopes determined statically.

        function outerFunc() {
        // the outer scope
        let outerVar = 'I am from outside!';

        function innerFunc() {
        // the inner scope
        console.log(outerVar); // 'I am from outside!'
        }

        return innerFunc;
        }

        const inner = outerFunc();
        inner();

Look at the last line of the snippet inner(): the innerFunc() invokation happens outside of outerFunc() scope. Still, how does JavaScript understand that outerVar inside innerFunc() corresponds to the variable outerVar of outerFunc()?

7. Conclusion

The scope is a policy that manages the availability of variables. A variable defined inside a scope is accessible only within that scope, but inaccessible outside.

In JavaScript, scopes are created by code blocks, functions, modules.

While const and let variables are scoped by code blocks, functions or modules, var variables are scoped only by functions or modules.

Scopes can be nested. Inside an inner scope you can access the variables of an outer scope.

The lexical scope consists of the outer function scopes determined statically. Any function, no matter the place where being executed, can access the variables of its lexical scope (this is the concept of closure).

## IIFE

Immediately Invoked Function Expression

ES5 -> JavaScript IIFE (Immediately Invoked Function Expression)
<img align="left" src="https://raw.githubusercontent.com/kambleaa007/Javascript/master/1.%20JavaScript%20Basics/pics/1.png" width="400" height="400">
ES6 -> JavaScript IIFE (arrow functions)
<img align="right" src="https://raw.githubusercontent.com/kambleaa007/Javascript/master/1.%20JavaScript%20Basics/pics/2.png" width="400" height="400">

## MVC

Model-view-controller is a design-framework (\*not a programming language) that allows us to separate behavior into a practical real-world structure. Almost 85% of web-based applications today have this underlying pattern in one way or the other.

ES5 -> Model-view-controller design-pattern
<img align="left" src="https://raw.githubusercontent.com/kambleaa007/Javascript/master/1.%20JavaScript%20Basics/pics/3.png" width="600" height="200">
ES6 -> Model-view-controller design-pattern (arrow functions)
<img align="right" src="https://raw.githubusercontent.com/kambleaa007/Javascript/master/1.%20JavaScript%20Basics/pics/4.png" width="600" height="200">

## async / await

Stop and wait until something is resolved.
It provides a way to maintain asynchronous processing in a more synchronous fashion.
For instance, you need to check if a user’s password is correct (compare to what exists in the server) before allowing the user to enter the system.
Or maybe you’ve performed a REST API request and you want the data to fully load before pushing it to the view.

1. Synchronous capabilities
2. Controls the behavior
3. Reduces “callback hell”

ES5 -> Async and Await promises
<img align="left" src="https://raw.githubusercontent.com/kambleaa007/Javascript/master/1.%20JavaScript%20Basics/pics/5.png" width="600" height="200">
ES6 -> Async and Await promises (arrow functions)
<img align="right" src="https://raw.githubusercontent.com/kambleaa007/Javascript/master/1.%20JavaScript%20Basics/pics/6.png" width="600" height="200">

## Callback

is a function that executes after another function has executed. It is also referred to as a call-after
A function that waits for another function to execute or return a value (array or object) is referred to as a callback.
A callback is a way to make asynchronous operations more synchronous (sequential order).

callback hell
have a recursive structure of callbacks (callbacks within callbacks within callbacks and so forth). This is not practical.

ES5 -> JavaScript Callback
<img align="left" src="https://raw.githubusercontent.com/kambleaa007/Javascript/master/1.%20JavaScript%20Basics/pics/7.png" width="400" height="400">
ES6 -> JavaScript Callback (arrow functions)
<img align="right" src="https://raw.githubusercontent.com/kambleaa007/Javascript/master/1.%20JavaScript%20Basics/pics/8.png" width="400" height="400">
