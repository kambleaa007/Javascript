//  import fs from 'fs'
const fs = require('fs');

var output = 
    fs.readFileSync('someData.txt','utf-8')
    .trim()
    .split('\n')
    .map(line => line.split(' '))
    .reduce( (cust, line) => {
        cust[line[0]] = cust[line[0]] || []
        cust[line[0]].push({
            name: line[1],
            price: line[2],
            quantity: line[3]
        })
        return cust
        }, {}   
    )

console.log(output)

// running command
// node .\ArraysMap.js


// Output:
// PS F:\spring-handson\Javascript\2. JavaScript Advanced\code> node .\ArraysMap.js       
// {
//   mark: [
//     { name: 'waffle', price: '', quantity: '80' },
//     { name: 'blender', price: '200', quantity: '1\r' },
//     { name: 'knife', price: '10', quantity: '4\r' }
//   ],
//   nikita: [
//     { name: 'waffle', price: '80', quantity: '1\r' },
//     { name: 'knife', price: '18', quantity: '2\r' },
//     { name: 'pot', price: '20', quantity: '3' }
//   ]
// }