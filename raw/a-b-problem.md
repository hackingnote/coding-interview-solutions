A + B Problem
===

Problem
-------

Write a function that add two numbers A and B. You should not use + or any arithmetic operators.

Notice: There is no need to read data from standard input stream. Both parameters are given in function aplusb, you job is to calculate the sum and return it.


Clarification
-------------

Are a and b both 32-bit integers?
Yes.

Can I use bit operation?
Sure you can.

Example
-------

Given a=1 and b=2 return 3

Challenge
---------

Of course you can just return a + b to get accepted. But Can you challenge not do it like that?

Solution
--------

``+`` is not allowed to use, however we can directly manipulate bits to simulate the plus operation. 

In its binary format, ``1 + 0`` will be ``1``, ``0 + 0`` will be ``0``, ``1 + 1`` will become ``0``, and the carry becomes ``1``. So the result without carry can be calculated by xor ``a ^ b``, and the carry ``a & b``, if carry is not ``0``, shift it left by 1, and add again:
 
```java
while(b != 0) {
    int carry = a & b;
    a = a ^ b;
    b = carry << 1;
}
```

For example, ``a`` = 1(binary as ``1``), ``b`` = 3(binary as ``11``)

```
======    Iteration #1    ======
                   a =          1
                   b =         11
        carry(a & b) =          1
        new a(a ^ b) =         10
new b(shifted carry) =         10

======    Iteration #2    ======
                   a =         10
                   b =         10
        carry(a & b) =         10
        new a(a ^ b) =          0
new b(shifted carry) =        100

======    Iteration #3    ======
                   a =          0
                   b =        100
        carry(a & b) =          0
        new a(a ^ b) =        100
new b(shifted carry) =          0

Final Result: 4
```

Try to plugin other numbers to fully understand how it works: [Source Code](https://github.com/hackingnote/coding-interview-solutions/tree/master/src/test/java/a-b-problem/StepByStep.java)

How about negative numbers?

Since negative numbers are in the form of [Two's Complement](https://en.wikipedia.org/wiki/Two%27s_complement), they can be treated in the same way. For example ``a`` = 1, ``b`` = -3:

======    Iteration #1    ======
                   a =                                1
                   b = 11111111111111111111111111111101
        carry(a & b) =                                1
        new a(a ^ b) = 11111111111111111111111111111100
new b(shifted carry) =                               10

======    Iteration #2    ======
                   a = 11111111111111111111111111111100
                   b =                               10
        carry(a & b) =                                0
        new a(a ^ b) = 11111111111111111111111111111110
new b(shifted carry) =                                0

Final Result: -2