# DS & Performance

[DS & Performance] Important Notes

## [Just DS & Performance] 08. DS & Performance

### Our Motivation for Asymptotic Analysis
You need stopwatch -> problem with stopwatch time -> diff machines, diff compilers, diff libs -> diff time -> doesnt give up clear picture !!!

what we can control?
1) Count Operations instead of Time -> Abstact way
2) Focus on how Performance scales -> if input gets bigger how algo will handle it
3) Go beyond input size -> how algo handle diff situations

### Counting Operations

How many operations get executed?
eg. what count as operation? Basic unit doesnt change as ip changes
str.length()
i++
str.charAt(int)
initialisation loop var i
return

### Introduction to Asymptotic Analysis

Motivation -> if ip twice as big, how many more ops do we need?

size of input -> N

str.charAt(i) --> constant time (nothing to do with size of str)
for (i=0; i< str.length(); i++)  --> str.length() --> linear time

f(n) = O( g(n) ) means, both f(n), g(n) grow in same way as ip grows

Big O -> rate of growth of two functions

Drop constant --> 1000000 = O(1)
Keep only dominant term --> Fastest growing term --> 
3n+3 = O(3n) = O(n)
g(n)=100+n^2+2^n --> g(n)= O(2^n)
f(n)= 4 log(n) + 3nlog(n) + n --> f(n) = nlog(n)

Formally,
f(n) = O(g(n)) means, 
constants N,c so for each n>N, f(n) <= C g(n)

for(){} // O(n)
for(){} // O(n)
if(){}  // O(1)
finally --> O(n)

Nested loops
for(){ // O(n)
    for(){ // O(n)
        if(){}// O(1)
    }
}
finally --> = O(n^2)

### Summary of Sorting

                Best        Average     Worst
Selection  --   O(n2)       O(n2)       O(n2)
Insertion  --   O(n)        O(n2)       O(n2)
Merge      --   O(nlog(n))  O(nlog(n))  O(nlog(n))
Quick      --   O(nlog(n))  O(nlog(n))  O(n2)







