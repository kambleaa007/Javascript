# Fun Fun Function


## split

'ABCD'.split("")        // ['A','B','C','D']


## map

## filter

## reject

## find

## reduce

## advance reduce


## closure
Easy Redable

A closure is the combination of a function bundled together (enclosed) with references to its surrounding state (the lexical environment). In other words, a closure gives you access to an outer function’s scope from an inner function. In JavaScript, closures are created every time a function is created, at function creation time.



````
var me = "Bruce Wayne"

function greetMe(){
        console.log("Hello "+ me )

}

greetMe()
````

support for closure
we have access to var outter scope of itself
greetMe remeber outer context even when greetMe called from complete different part of app, it will still ref to outer context



other languages need to pass variable to function
greetMe("Hello World")






### Recursion


`````
let categories = [
        { id: 'animal', 'parent': null },
        { id: 'mammal', 'parent': 'animal' },
        { id: 'dog', 'parent': 'mammal' },
        { id: 'cat', 'parent': 'mammal' },
        { id: 'human', 'parent': 'mammal' }
]

let makeTree = (categories, parent) => {
        let node = {}
        categories
                .filter(c=> c.parent === parent)
                .forEach(c=> node[c.id] = makeTree(categories,c.id))
        return node;        
}

console.log(
        JSON.stringify(
                makeTree(categories, null, 2)
        )
)

`````
> {"animal":{"mammal":{"dog":{},"cat":{},"human":{}}}}





## Promises

Promise.all([
        fetch(),
        fetch(),
        fetch()
        ])
        .then((i)=>{
                i.forEach(j=>{console.log(j)})
})
.catch((err)=>{console.log(err)})


Promises are composable
Handle err at one place only
Any one fetch fails everything fails





## Functor

Objects that has .map() method are functors
Arrays in JS implements map 
Promises Streams Trees implements map

.map() method takes functor content and transforms them using transformation callback passed to map
returns same functor of same type
contains transformed values 


given value + function
unwrap value into indivial parts
feed those parts into given function
then take values
returns them in structured form


.map()

you can do .map().map().map().map() chaing with promises and streams

.filter()
is not functor



.forEach is not functor --> doent returns anything which is in stuctured form


``````
function plus1(val){
        return val +1;
}
plus1(3)     // 4 works

plus1([3,4]) // [4,5] but, breaks the code

plus1('ABC') // BCD but, breaks the code






// functors ---->

[3,4].map(plus1)   // [4,5]


function minus1(val){
        return val -1;
}

[3,4].map(minus1)       // [2,3]
[]

``````


## Streams



















To Be Continued...
