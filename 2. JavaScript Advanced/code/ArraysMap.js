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
