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


### Scoping rules

Main difference is scoping rules. 
Variables declared by var keyword are scoped to the immediate `function body` (hence the function scope) 
while let variables are scoped to the immediate `enclosing block` denoted by { } {hence the block scope}.

The reason why `let` keyword was introduced to the language was `function scope is confusing` and 
was one of the main sources of bugs in JavaScript.



